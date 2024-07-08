package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Semanas")
public class Semana {
    @Id
    @Column(name = "SemanaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer semanaid;

    private String cursoid;
    private Integer numerosemana;
    private java.lang.String tema;
    private java.lang.String descripcion;
}
