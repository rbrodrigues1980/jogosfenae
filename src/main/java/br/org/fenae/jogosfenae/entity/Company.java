package br.org.fenae.jogosfenae.entity;

import br.org.fenae.jogosfenae.entity.enums.CompanyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import br.org.fenae.jogosfenae.entity.Edition;

import lombok.extern.java.Log;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenae_Company",
        uniqueConstraints = {
                @UniqueConstraint(name = "FENAE_UK_COMPANY_EDITION_TITLE", columnNames = {"title", "editionId"})
        }
)
@Log
public class Company extends AbstractEntity{

    @Column
    @NotNull(message = "{validation.field.required}")
    private String title;

    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer participantNumber;

    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer presidentNumber;

    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer sportsDirectorNumber;

    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer athleteNumber;
    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer parathleteNumber;

    @NotNull(message = "{validation.field.required}")
    @PositiveOrZero(message = "{validation.field.nonnegative}")
    private Integer technicalNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editionId", nullable = false, foreignKey = @ForeignKey(name = "EDICAO_FK_EDICAOID"))
    private Edition edition;

    public void setTitle(String title) {
        log.info("Entrou no método");
        this.title = CompanyEnum.toString(title);
    }
}
