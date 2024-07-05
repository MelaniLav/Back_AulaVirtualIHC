package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    private Integer tareaid;

    @OneToOne
    @JoinColumn(name = "SemanaID")
    private Semana semanaid;
    private String descripcion;
    private Float nota;
}
