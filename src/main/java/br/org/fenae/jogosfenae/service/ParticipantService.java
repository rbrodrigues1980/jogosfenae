package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.model.Participant;
import br.org.fenae.jogosfenae.repository.CompanyRepository;
import br.org.fenae.jogosfenae.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Participant save(Participant participant){
        participant.setId(null);
        return participantRepository.save(participant);
    }

    public List<Participant> findAll(){
        return participantRepository.findAll();
    }

}
