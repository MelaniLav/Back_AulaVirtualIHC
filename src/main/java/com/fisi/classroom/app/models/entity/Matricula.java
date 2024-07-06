package com.fisi.classroom.app.models.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Matricula")
public class Matricula {
    @Id
    @Column(name ="id_matricula")
    private Integer id_matricula;
    @OneToOne
    @JoinColumn(name = "id_alumno")
    private Alumno id_alumno;
    @OneToOne
    @JoinColumn(name = "id_plan")
    private PlanEstudio id_plan;
    @OneToOne
    @JoinColumn(name = "id_curso")
    private Curso id_curso;
    private java.lang.String facultad;
    private java.lang.String escuela;
    private java.lang.String periodo;
    private Date fecha_matricula;

}
