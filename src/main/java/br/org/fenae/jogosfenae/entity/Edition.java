package br.org.fenae.jogosfenae.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenae_Edition"
)
public class Edition extends AbstractEntity {

    @NotNull(message = "{validation.field.required}")
    private String title;

    @NotNull(message = "{validation.field.required}")
    private String description;
}
