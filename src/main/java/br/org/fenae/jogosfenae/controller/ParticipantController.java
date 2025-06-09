package br.org.fenae.jogosfenae.controller;

import br.org.fenae.jogosfenae.entity.Participant;
import br.org.fenae.jogosfenae.exception.CustomErrorType;
import br.org.fenae.jogosfenae.repository.CompanyRepository;
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
    @Autowired
    private CompanyRepository companyRepository;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CustomErrorType> save(@Valid @RequestBody Participant participant, @RequestParam("companyId") String companyId){
        try {
            participantService.saveParticipant(participant, companyId);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/participantId?companyId={companyId}")
                    .buildAndExpand(participant.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Sua Apcef já atingiu limite de participantes"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{participantId}")
    public ResponseEntity<Participant> findByIdParticipant(@PathVariable String participantId){
        Participant participant = participantService.findByIdParticipant(participantId);
        return ResponseEntity.ok().body(participant);
    }

    @PutMapping("/{participantId}/{companyId}")
    public ResponseEntity<Void> updateParticipant(@PathVariable String participantId, @RequestBody Participant participant){
        participantService.updateParticipant(participantId, participant);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Participant>> findAll(){
        return ResponseEntity.ok(participantService.findAll());
    }

    @DeleteMapping("/{participantId}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable String participantId){
        participantService.deleteParticipant(participantId);
        return ResponseEntity.noContent().build();
    }

}
