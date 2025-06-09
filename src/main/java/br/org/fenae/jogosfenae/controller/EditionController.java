package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.entity.Edition;
import br.org.fenae.jogosfenae.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rest/v1/edition")
public class EditionController {

    @Autowired
    private EditionService editionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Edition edition) {
        editionService.saveEdition(edition);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{editionId}")
                .buildAndExpand(edition.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{editionId}")
    public ResponseEntity<Edition> findById(@PathVariable String editionId) {
        return ResponseEntity.ok(editionService.findById(editionId));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Edition> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(editionService.findByTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<Edition>> findAll() {
        return ResponseEntity.ok(editionService.findAll());
    }

    @PutMapping("/{editionId}")
    public ResponseEntity<Void> update(@PathVariable String editionId, @RequestBody Edition edition) {
        editionService.updateEdition(editionId, edition);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{editionId}")
    public ResponseEntity<Void> delete(@PathVariable String editionId) {
        editionService.deleteEdition(editionId);
        return ResponseEntity.noContent().build();
    }
}
