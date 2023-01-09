package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.model.Company;
import br.org.fenae.jogosfenae.model.dto.CompanyDTO;
import br.org.fenae.jogosfenae.model.dto.CompanyRequestDTO;
import br.org.fenae.jogosfenae.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j(topic = "COMPANY_CONTROLLER")
@RestController
@RequestMapping(value = "/api/rest/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/company")
    public ResponseEntity<Void> save(@Valid @RequestBody CompanyDTO companyDTO) {
        Company company =  companyService.fromDTOCompany(companyDTO);
        companyService.save(company);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{companyId}")
                .buildAndExpand(company.getCompanyId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/company/{companyId}")
    public ResponseEntity<Company> find(@PathVariable Integer companyId){
        Company company = companyService.find(companyId);
        return ResponseEntity.ok().body(company);
    }

    @GetMapping(value = "/company")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/company/{companyId}")
    public ResponseEntity<Void> update(@PathVariable Integer companyId, @RequestBody CompanyRequestDTO companyRequestDTO){
        Company company = companyService.updateDTO(companyRequestDTO);
        company.setCompanyId(companyId);
        companyService.update(company);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/company/{companyId}")
    public ResponseEntity<Void> delete(@PathVariable Integer companyId){
        companyService.delete(companyId);
        return ResponseEntity.noContent().build();
    }

}