package com.fisi.classroom.app.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "materialesextra")
public class MaterialExtra {

    @Id
    private String materialextraid;

    @OneToOne
    @JoinColumn(name = "CursoID")
    private Curso cursoid;
    private String tipo;
    private String descripcion;
    private String URL;
    private String archivo;
}
