package com.fisi.classroom.app.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name ="id_rol")
    private Integer id_rol;
    private String rol;

}
