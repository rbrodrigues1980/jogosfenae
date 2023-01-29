package br.org.fenae.jogosfenae.model;

import br.org.fenae.jogosfenae.model.enums.CompanyEnum;
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
@Table(name = "fenae_Company")
@Log
public class Company extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "Campo é obrigatório")
    private String name;

    @NotNull(message = "Campo é obrigatório")
    private Integer participantNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
    @JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_participantId"))
    private Participant participant;

    public void setName(String name) {
        log.info("Entrou no método");
        this.name = CompanyEnum.toString(name);
    }
}
