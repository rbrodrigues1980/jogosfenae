package br.org.fenae.jogosfenae.service;

import br.org.fenae.jogosfenae.exception.CompanyNotFoundException;
import br.org.fenae.jogosfenae.exception.NoSuchElementFoundException;
import br.org.fenae.jogosfenae.model.Company;
import br.org.fenae.jogosfenae.model.dto.CompanyDTO;
import br.org.fenae.jogosfenae.model.dto.CompanyRequestDTO;
import br.org.fenae.jogosfenae.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company fromDTOCompany(CompanyDTO companyDTO){
        return new Company().builder()
                .companyName(companyDTO.getCompanyName())
                .participant(companyDTO.getParticipant())
                .build();
    }

    @Transactional
    public void save(Company company) {
        company.setCompanyId(null);
        companyRepository.save(company);
    }

    public Company updateDTO(CompanyRequestDTO companyRequestDTO){
        return new Company(null, null, companyRequestDTO.getParticipant(), null, null);
    }

    public void update(Company company){
        Company updateCompany = find(company.getCompanyId());
        updateCompany.setParticipant(company.getParticipant());
        companyRepository.save(updateCompany);
    }

    public Company find(Integer companyId){
        Optional<Company> company = companyRepository.findById(companyId);
        return company.orElseThrow(
                () -> new CompanyNotFoundException("Entidade não localizada: " + Company.class.getName())
        );
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public void delete(Integer companyId){
        find(companyId);
        try {
            companyRepository.deleteById(companyId);
        } catch (DataIntegrityViolationException e){
            throw new CompanyNotFoundException("Não é possível excluir a entidade!");
        }
    }

}
