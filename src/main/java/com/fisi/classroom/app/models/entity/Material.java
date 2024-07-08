package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "materiales")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialid;

    @OneToOne
    @JoinColumn(name = "SemanaID")
    private Semana semanaid;
    private String tipo;
    private String descripcion;
    private String URL;
    private byte[] archivo;
}
