package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @Column(name="id_profesor")
    private Integer id_profesor;
    private String nombre_profesor;
    private String escuela;
    private String especialidad;
    private String fecha_nacimiento;
    @OneToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta idcuenta;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

}
