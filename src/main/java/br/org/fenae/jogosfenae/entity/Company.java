package br.org.fenae.jogosfenae.entity;

import br.org.fenae.jogosfenae.entity.enums.CompanyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import lombok.extern.java.Log;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenae_Company",
        uniqueConstraints = {
                @UniqueConstraint(name = "FENAE_UK_COMPANY_NAME", columnNames = "name")
        }
)
@Log
public class Company extends AbstractEntity{

    @Id
    @JsonProperty("companyId")
    @Column(length = 32)
    private String companyId;

    @Column(unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String name;

    @NotNull(message = "Campo é obrigatório")
    private Integer participantNumber;

    @NotNull(message = "Campo é obrigatório")
    private Integer presidentNumber;

    @NotNull(message = "Campo é obrigatório")
    private Integer sportsDirectorNumber;

    @NotNull(message = "Campo é obrigatório")
    private Integer athleteNumber;
    @NotNull(message = "Campo é obrigatório")
    private Integer parathleteNumber;

    @NotNull(message = "Campo é obrigatório")
    private Integer technicalNumber;

    public void setName(String name) {
        log.info("Entrou no método");
        this.name = CompanyEnum.toString(name);
    }
}
