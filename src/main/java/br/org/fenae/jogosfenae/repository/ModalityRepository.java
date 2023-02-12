package br.org.fenae.jogosfenae.repository;

import br.org.fenae.jogosfenae.entity.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Integer> {
}
