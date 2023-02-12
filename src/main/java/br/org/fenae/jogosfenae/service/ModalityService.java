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

@Service
public class ModalityService {

    @Autowired
    ModalityRepository modalityRepository;

    @Transactional
    public Modality saveModality(Modality modality){
        modality.setModalityId(null);
        return modalityRepository.save(modality);
    }

    public Modality findByIdModality(Integer modalityId){
        Optional<Modality> modality = modalityRepository.findById(modalityId);
        return modality.orElseThrow(() -> new ModalityNotFoundExcpetion("Modalidade não localizada: " + Modality.class.getName()));
    }

    @Transactional
    public void updateModality(Integer modalityId, Modality modality){
        modality.setModalityId(modalityId);
        Modality updateModality = findByIdModality(modality.getModalityId());
        modalityRepository.save(updateModality);
    }

    public List<Modality> findAllModality(){
        return modalityRepository.findAll();
    }

    @Transactional
    public void deleteModality(Integer modalityId){
        findByIdModality(modalityId);
        try {
            modalityRepository.deleteById(modalityId);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new ModalityNotFoundExcpetion("Não é possível excluir da modalidade!");
        }
    }


}
