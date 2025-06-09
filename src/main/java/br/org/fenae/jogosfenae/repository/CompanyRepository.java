package br.org.fenae.jogosfenae.repository;

import br.org.fenae.jogosfenae.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
