package br.org.fenae.jogosfenae.model;

import br.org.fenae.jogosfenae.model.enums.CompanyEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fenae_Company")
public class Company extends AbstractEntity{

    @Column(name = "companyName", unique = true)
    private String companyName;

    @Column(name = "participant")
    @NotNull(message = "Campo é obrigatório")
    private Integer participant;

    public void setCompanyName(String companyName) {
        this.companyName = CompanyEnum.toString(companyName);
    }
}
