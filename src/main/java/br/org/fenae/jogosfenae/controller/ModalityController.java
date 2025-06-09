package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.entity.Modality;
import br.org.fenae.jogosfenae.service.ModalityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j(topic = "MODALITY_CONTROLLER")
@RestController
@RequestMapping(value = "/api/rest/v1/modality")
public class ModalityController {

    @Autowired
    private ModalityService modalityService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Modality modality) {
        try {
            log.info("Modalidade salva com sucesso: {}", modality.getName());
            modalityService.saveModality(modality);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{modalityId}")
                    .buildAndExpand(modality.getId())
                    .toUri();
            log.info("Modalidade salva com sucesso: {}", modality.toString());
            return ResponseEntity.created(uri).build();
        } catch (Exception exception){
            log.error("Erro ao salvar molidade: {}", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{modalityId}")
    public ResponseEntity<Modality> find(@PathVariable String modalityId){
        Modality modality = modalityService.findByIdModality(modalityId);
        return ResponseEntity.ok().body(modality);
    }

    @GetMapping
    public ResponseEntity<List<Modality>> findAllCompany(){
        return ResponseEntity.ok(modalityService.findAllModality());
    }

    @PutMapping("/{modalityId}")
    public ResponseEntity<Void> updateModality(@PathVariable String modalityId, @RequestBody Modality modality){
        modalityService.updateModality(modalityId, modality);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{modalityId}")
    public ResponseEntity<Void> deleteModality(@PathVariable String modalityId){
        modalityService.deleteModality(modalityId);
        return ResponseEntity.noContent().build();
    }
}
