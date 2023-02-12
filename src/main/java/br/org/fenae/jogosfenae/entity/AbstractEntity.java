package br.org.fenae.jogosfenae.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity {

    @Column(name = "createdDateTime")
    @CreationTimestamp
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDateTime;

    @Column(name = "updatedDateTime")
    @UpdateTimestamp
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedDateTime;

    //SOLID e desing pattern
}
