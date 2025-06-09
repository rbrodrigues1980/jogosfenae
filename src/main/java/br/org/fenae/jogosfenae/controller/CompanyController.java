package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.entity.Company;
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
@RequestMapping(value = "/api/rest/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /*@ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public CompanyDTO save(@Valid @RequestBody Company company) {
        return companyService.save(company);
    }*/

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Company company) {
        companyService.saveCompany(company);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{companyId}")
                .buildAndExpand(company.getCompanyId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> find(@PathVariable String companyId){
        Company company = companyService.findByIdCompany(companyId);
        return ResponseEntity.ok().body(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAllCompany());
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Void> update(@PathVariable String companyId, @RequestBody Company company){
        companyService.updateCompany(companyId, company);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> delete(@PathVariable String companyId){
        companyService.deleteCompany(companyId);
        return ResponseEntity.noContent().build();
    }

}