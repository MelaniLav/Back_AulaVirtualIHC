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
    private String id_curso;

    @OneToOne
    @JoinColumn(name="id_plan")
    private PlanEstudio id_plan;
    @OneToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;
    private String nombre_curso;
    private String ciclo;
    private Integer creditos;
    private String horario;

}
