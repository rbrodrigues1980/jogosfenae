package br.org.fenae.jogosfenae.repository;

import br.org.fenae.jogosfenae.entity.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditionRepository extends JpaRepository<Edition, String> {
    Optional<Edition> findByTitleIgnoreCase(String title);
}
