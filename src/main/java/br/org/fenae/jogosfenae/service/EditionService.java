package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.entity.Edition;
import br.org.fenae.jogosfenae.exception.NoSuchElementFoundException;
import br.org.fenae.jogosfenae.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    @Transactional
    public Edition saveEdition(Edition edition) {
        edition.setEditionId(null);
        return editionRepository.save(edition);
    }

    public Edition findById(Integer editionId) {
        Optional<Edition> edition = editionRepository.findById(editionId);
        return edition.orElseThrow(() ->
                new NoSuchElementFoundException("Edição não encontrada: " + Edition.class.getName()));
    }

    public Edition findByTitle(String title) {
        Optional<Edition> edition = editionRepository.findByTitleIgnoreCase(title);
        return edition.orElseThrow(() ->
                new NoSuchElementFoundException("Edição não encontrada: " + Edition.class.getName()));
    }

    public List<Edition> findAll() {
        return editionRepository.findAll();
    }

    @Transactional
    public void updateEdition(Integer editionId, Edition edition) {
        Edition update = findById(editionId);
        update.setTitle(edition.getTitle());
        update.setDescription(edition.getDescription());
        editionRepository.save(update);
    }

    @Transactional
    public void deleteEdition(Integer editionId) {
        findById(editionId);
        try {
            editionRepository.deleteById(editionId);
        } catch (DataIntegrityViolationException e) {
            throw new NoSuchElementFoundException("Não é possível excluir a edição!");
        }
    }
}
