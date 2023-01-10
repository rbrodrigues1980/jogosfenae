package br.org.fenae.jogosfenae.model;

import br.org.fenae.jogosfenae.model.enums.CompanyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fenae_Company")
public class Company extends AbstractEntity{

    @Column(name = "companyName", unique = true)
    private String companyName;

    @Column(name = "participant")
    @NotNull(message = "Campo é obrigatório")
    private Integer participant;

    public void setCompanyName(String companyName) {
        this.companyName = CompanyEnum.toString(companyName);
    }
}
