package com.fisi.classroom.app.models.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SemanaAloneDto {
    public Integer semanaid;
    private String tema;
    private Integer numerosemana;
    private String descripcion;
}
