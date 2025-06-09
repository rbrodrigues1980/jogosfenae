package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.exception.CompanyNotFoundException;
import br.org.fenae.jogosfenae.entity.Company;
import br.org.fenae.jogosfenae.entity.dto.CompanyRequestDTO;
import br.org.fenae.jogosfenae.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Company saveCompany(Company company) {
        company.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        return companyRepository.save(company);
    }

    public Company updateDTO(CompanyRequestDTO companyRequestDTO){
        return new Company(null, null, null, null, null, null, null);
    }

    public void updateCompany(String companyId, Company company){
        company.setId(companyId);
        Company updateCompany = findByIdCompany(company.getId());
        updateCompany.setParticipantNumber(company.getParticipantNumber());
        updateCompany.setPresidentNumber(company.getPresidentNumber());
        updateCompany.setSportsDirectorNumber(company.getSportsDirectorNumber());
        updateCompany.setAthleteNumber(company.getAthleteNumber());
        updateCompany.setParathleteNumber(company.getParathleteNumber());
        updateCompany.setTechnicalNumber(company.getTechnicalNumber());
        companyRepository.save(updateCompany);
    }

    public Company findByIdCompany(String companyId){
        Optional<Company> company = companyRepository.findById(companyId);
        return company.orElseThrow(
                () -> new CompanyNotFoundException("Entidade não localizada: " + Company.class.getName())
        );
    }

    public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }

    public void deleteCompany(String companyId){
        findByIdCompany(companyId);
        try {
            companyRepository.deleteById(companyId);
        } catch (DataIntegrityViolationException e){
            throw new CompanyNotFoundException("Não é possível excluir a entidade!");
        }
    }

}
