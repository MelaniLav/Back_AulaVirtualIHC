package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "semanas")
public class Semana {
    @Id
    private Integer semanaid;

    @OneToOne
    @JoinColumn(name = "CursoID")
    private Curso cursoid;
    private Integer numerosemana;
    private String tema;
    private String descripcion;
}
