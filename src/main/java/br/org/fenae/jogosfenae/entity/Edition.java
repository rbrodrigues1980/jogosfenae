package br.org.fenae.jogosfenae.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@br.org.fenae.jogosfenae.validation.EditionValid
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "fenae_Edition"
)
public class Edition extends AbstractEntity {

    @NotNull(message = "{validation.field.required}")
    @Size(min = 5, max = 255)
    private String title;

    @Column(name = "startDateTime")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "{validation.field.required}")
    private LocalDateTime startDateTime;

    @Column(name = "endDateTime")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "{validation.field.required}")
    private LocalDateTime endDateTime;

    @Column(name = "membershipDate")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "{validation.field.required}")
    private LocalDate membershipDate;

    @Column(name = "bornFrom")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate bornFrom;

    @Schema(description = "Nascidos até")
    @Column(name = "bornUntil")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate bornUntil;

    @Column(name = "linkExpirationDate")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime linkExpirationDate;

    private String link;

    @NotNull(message = "{validation.field.required}")
    @Email
    private String email;

    @NotNull(message = "{validation.field.required}")
    private String description;

    @Column(name = "currentEdition")
    private Boolean currentEdition;
}
