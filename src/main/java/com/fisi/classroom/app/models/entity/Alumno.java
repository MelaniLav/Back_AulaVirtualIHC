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
@Table(name = "alumno")
public class Alumno {

    @Id
    private Integer id_alumno;

    @OneToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
    private String nombrealumno;
    private String situacion;

    @Column(name = "fecha_ingreso")
    private Date fechaingreso;
    @Column(name = "fecha_nacimiento")
    private Date fechanacimiento;
}
