package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "id_cuenta")
    private Integer id_cuenta;
    private String correo;
    private String contrasena;
    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;


}
