package br.org.fenae.jogosfenae.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fenae_Participant")
public class Participant extends AbstractEntity {

    @NotEmpty(message = "Nome obrigatório")
    private String name;

    @NotNull(message = "Data de nascimento obrigatório")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    @Column(name = "gender")
    @NotNull(message = "")
    private String gender;

    @Column(name = "phone")
    @NotNull(message = "")
    private String phone;

    @Column(name = "privateEmail")
    @NotNull(message = "")
    @Email
    private String privateEmail;

    @Column(name = "businessEmail")
    @Email
    private String businessEmail;

    @Column(name = "cpf", unique = true)
    @NotNull(message = "")
    @CPF
    private String cpf;

    @Column(name = "rg")
    @NotNull(message = "")
    private String rg;

    @Column(name = "registration")
    @NotNull(message = "")
    private String registration;

    @Column(name = "function")
    @NotNull(message = "")
    private String function;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "companyId", nullable = false, foreignKey = @ForeignKey(name = "FK_companyId"))
    private Company company;

}
