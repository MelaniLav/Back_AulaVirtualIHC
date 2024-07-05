package com.fisi.classroom.app.models.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clase")
public class Clase {
    @Id
    @Column(name ="id_clase")
    private Integer id_clase;
    @OneToOne
    @JoinColumn(name ="id_curso")
    private Curso id_curso;
    private Integer semana;
    private String documentos;
    private String anotaciones;

}
