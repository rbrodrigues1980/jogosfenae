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

    @Column(unique = true)
    @NotNull(message = "{validation.field.required}")
    private String name;

    @NotNull(message = "{validation.field.required}")
    private Integer participantNumber;

    @NotNull(message = "{validation.field.required}")
    private Integer presidentNumber;

    @NotNull(message = "{validation.field.required}")
    private Integer sportsDirectorNumber;

    @NotNull(message = "{validation.field.required}")
    private Integer athleteNumber;
    @NotNull(message = "{validation.field.required}")
    private Integer parathleteNumber;

    @NotNull(message = "{validation.field.required}")
    private Integer technicalNumber;

    public void setName(String name) {
        log.info("Entrou no método");
        this.name = CompanyEnum.toString(name);
    }
}
