package br.org.fenae.jogosfenae.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenaeModality",
        uniqueConstraints = {
                @UniqueConstraint(name = "FENAE_UK_MODALITY_NAME", columnNames = "name")
        }
)
@Log
public class Modality extends AbstractEntity {

    @Id
    @JsonProperty("modalityId")
    @Column(length = 32)
    private String modalityId;

    @Column(unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String name;
}
