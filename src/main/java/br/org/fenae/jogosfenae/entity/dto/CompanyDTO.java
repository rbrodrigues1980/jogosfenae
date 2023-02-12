package br.org.fenae.jogosfenae.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    @Id
    @Column(name = "companyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name = "companyName", unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String name;

    @NotNull(message = "Campo é obrigatório")
    private Integer participantNumber;

    /*public void setCompanyName(String companyName) {
        this.companyName = CompanyEnum.toString(companyName);
    }*/

}
