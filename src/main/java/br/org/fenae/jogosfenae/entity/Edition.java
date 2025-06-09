package br.org.fenae.jogosfenae.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenaeEdition",
        uniqueConstraints = {
                @UniqueConstraint(name = "FENAE_UK_EDITION_TITLE", columnNames = "title")
        }
)
public class Edition extends AbstractEntity {

    @Id
    @JsonProperty("editionId")
    @Column(length = 32)
    private String editionId;

    @Column(unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String title;

    @NotNull(message = "Campo é obrigatório")
    private String description;
}
