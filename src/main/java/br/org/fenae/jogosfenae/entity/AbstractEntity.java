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
    // Accept ISO 8601 date time strings such as "2025-06-09T00:02:55.958Z"
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime createdDateTime;

    @Column(name = "updatedDateTime")
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime updatedDateTime;

    //SOLID e desing pattern
}
