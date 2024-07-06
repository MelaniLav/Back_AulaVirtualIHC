package com.fisi.classroom.app.models.dto;

import com.fisi.classroom.app.models.entity.Curso;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class MaterialExtraDTO {
    private String materialextraid;
    private String cursoid;
    private String tipo;
    private String descripcion;
    private String ruta;
}
