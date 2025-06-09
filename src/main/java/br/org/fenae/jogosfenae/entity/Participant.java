package br.org.fenae.jogosfenae.entity;

import br.org.fenae.jogosfenae.entity.enums.FunctionEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Id
    @JsonProperty("participantId")
    @Column(length = 32)
    private String participantId;

    @NotEmpty(message = "Nome obrigatório")
    private String name;

    @NotNull(message = "Data de nascimento obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
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

    @Column(name = "cpf", unique = false)
    @NotNull(message = "")
    @CPF
    private String cpf;

    @Column(name = "rg")
    @NotNull(message = "")
    private String rg;

    @Column(name = "registration")
    @NotNull(message = "")
    private String registration;

    @JsonProperty("function")
    @NotNull(message = "")
    private String functionName;

    public void setFunctionName(String name) {
        this.functionName = FunctionEnum.toString(name);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId", nullable = false, foreignKey = @ForeignKey(name = "FK_companyId"))
    private Company company;

}
