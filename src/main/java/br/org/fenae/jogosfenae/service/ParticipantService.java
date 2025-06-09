package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.entity.Company;
import br.org.fenae.jogosfenae.entity.Participant;
import br.org.fenae.jogosfenae.exception.ParticipantNotFoundException;
import br.org.fenae.jogosfenae.repository.CompanyRepository;
import br.org.fenae.jogosfenae.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j(topic = "PARTICIPANT_SERVICE")
@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Participant saveParticipant(Participant participant, String companyId){
        Company company = companyRepository.findById(companyId).get();

        // Conta a quantidade de participantes já cadastrados para a empresa
        Integer count = participantRepository.findByCompanyId(company.getCompanyId());

        // Verifica se a quantidade de participantes já atingiu o limite permitido para a empresa
        if (count >= company.getParticipantNumber()) {
            throw new RuntimeException("Limite de participantes da Apcef atingido");
        }

        // Gera um GUID de 32 posições para o novo participante
        participant.setParticipantId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        participant.setCompany(company);
        return participantRepository.save(participant);
    }

    public Participant findByIdParticipant(String participantId){
        Optional<Participant> participant = participantRepository.findById(participantId);
        return participant.orElseThrow(
                () -> new ParticipantNotFoundException("Participante não encontrado!" + Participant.class.getName())
        );
    }

    public void updateParticipant(String participantId, Participant participant){

        if (participantId == null || participant == null) {
            throw new IllegalArgumentException("participantId and participant must not be null");
        }

        Participant updateParticipant = findByIdParticipant(participantId);
        if (updateParticipant == null) {
            throw new ParticipantNotFoundException("Participant with id " + participantId + " not found");
        }

        participant.setParticipantId(participantId);
        //Participant updateParticipant = findByIdParticipant(participantId);
        updateParticipant.setName(participant.getName());
        updateParticipant.setBirthDate(participant.getBirthDate());
        updateParticipant.setGender(participant.getGender());
        updateParticipant.setPhone(participant.getPhone());
        updateParticipant.setPrivateEmail(participant.getPrivateEmail());
        updateParticipant.setBusinessEmail(participant.getBusinessEmail());
        updateParticipant.setCpf(participant.getCpf());
        updateParticipant.setRg(participant.getRg());
        updateParticipant.setRegistration(participant.getRegistration());
        updateParticipant.setFunctionName(participant.getFunctionName());
        updateParticipant.setCompany(participant.getCompany());
        participantRepository.save(updateParticipant);
    }

    public List<Participant> findAll(){
        return participantRepository.findAll();
    }

    public void deleteParticipant(String participantId){
        findByIdParticipant(participantId);
        try {
            participantRepository.deleteById(participantId);
        } catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new ParticipantNotFoundException("Não foi possível exluir o participante!");
        }
    }


}
