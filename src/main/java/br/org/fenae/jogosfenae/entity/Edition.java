package br.org.fenae.jogosfenae.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenae_Edition"
)
public class Edition extends AbstractEntity {

    @Id
    @JsonProperty("editionId")
    @Column(length = 32)
    private String editionId;

    @NotNull(message = "Campo é obrigatório")
    private String title;

    @NotNull(message = "Campo é obrigatório")
    private String description;
}
