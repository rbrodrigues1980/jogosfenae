package br.org.fenae.jogosfenae.model;

import br.org.fenae.jogosfenae.model.enums.CompanyEnum;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import lombok.extern.java.Log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
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
    private Integer participant;

    public void setName(String name) {
        log.info("Entrou no método");
        this.name = CompanyEnum.toString(name);
    }
}
