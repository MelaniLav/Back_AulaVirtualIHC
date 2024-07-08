package com.fisi.classroom.app.models.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemanaDto {
    private String idcurso;
    private String tema;
    private Integer numerosemana;
    private String descripcion;
    private List<TareaDto> tareas;
    private List<MaterialDto> materiales;

}
