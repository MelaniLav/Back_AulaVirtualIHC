package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name="id_curso")
    private java.lang.String id_curso;

    @OneToOne
    @JoinColumn(name="id_plan")
    private PlanEstudio id_plan;
    @OneToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;

    @Column(name="nombre_curso")
    private java.lang.String nombrecurso;
    private java.lang.String ciclo;
    private Integer creditos;
    private java.lang.String horario;

}
