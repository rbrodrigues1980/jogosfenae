package br.org.fenae.jogosfenae.repository;

import br.org.fenae.jogosfenae.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {

    @Query("SELECT COUNT(p) FROM Participant p WHERE p.company.id = :companyId")
    Integer findByCompanyId(@Param("companyId") String companyId);

}
