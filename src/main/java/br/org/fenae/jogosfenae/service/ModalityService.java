package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.entity.Modality;
import br.org.fenae.jogosfenae.exception.ModalityNotFoundExcpetion;
import br.org.fenae.jogosfenae.repository.ModalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModalityService {

    @Autowired
    ModalityRepository modalityRepository;

    @Transactional
    public Modality saveModality(Modality modality){
        modality.setModalityId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        return modalityRepository.save(modality);
    }

    public Modality findByIdModality(String modalityId){
        Optional<Modality> modality = modalityRepository.findById(modalityId);
        return modality.orElseThrow(() -> new ModalityNotFoundExcpetion("Modalidade não localizada: " + Modality.class.getName()));
    }

    @Transactional
    public void updateModality(String modalityId, Modality modality){
        Modality updateModality = findByIdModality(modalityId);
        updateModality.setName(modality.getName());
        modalityRepository.save(updateModality);
    }

    public List<Modality> findAllModality(){
        return modalityRepository.findAll();
    }

    @Transactional
    public void deleteModality(String modalityId){
        findByIdModality(modalityId);
        try {
            modalityRepository.deleteById(modalityId);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new ModalityNotFoundExcpetion("Não é possível excluir da modalidade!");
        }
    }


}
