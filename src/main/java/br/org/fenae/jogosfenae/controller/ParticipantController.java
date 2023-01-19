package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.model.Participant;
import br.org.fenae.jogosfenae.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rest/v1/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Participant participant){
        participantService.save(participant);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(participant.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Participant>> findAll(){
        return ResponseEntity.ok(participantService.findAll());
    }

}
