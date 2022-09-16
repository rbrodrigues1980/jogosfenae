package br.org.fenae.jogosfenae.model.dto;

import br.org.fenae.jogosfenae.model.enums.CompanyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    @Column(name = "companyName", unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String companyName;

    @NotNull(message = "Campo é obrigatório")
    private Integer participant;

    public void setCompanyName(String companyName) {
        this.companyName = CompanyEnum.toString(companyName);
    }

}
