package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.model.Company;
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
        companyService.save(company);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(company.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> find(@PathVariable Integer id){
        Company company = companyService.find(id);
        return ResponseEntity.ok().body(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Company company){
        companyService.update(id, company);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}