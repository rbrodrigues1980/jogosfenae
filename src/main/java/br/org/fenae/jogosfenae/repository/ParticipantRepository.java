package br.org.fenae.jogosfenae.repository;

import br.org.fenae.jogosfenae.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    @Query("SELECT COUNT(*) FROM Participant p JOIN Company c ON p.company.id = c.id WHERE c.id = :companyId")
    Integer findByCompanyId(@Param("companyId") Integer companyId);

}
