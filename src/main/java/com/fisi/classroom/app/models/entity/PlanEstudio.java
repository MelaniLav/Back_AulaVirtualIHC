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
@Table(name = "plan_estudio")
public class PlanEstudio {
    @Id
    @Column(name="id_plan")
    private Integer id_plan;
    private String descripcion;
}
