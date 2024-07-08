package com.fisi.classroom.app.util;

import com.fisi.classroom.app.models.dto.TareaDto;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TareaConvert {
    public List<Tarea> convertTarea(List<TareaDto> tareadto, Semana semana){
        return tareadto.stream().map(dto -> Tarea.builder()
                .semanaid(semana)
                .descripcion(dto.getDescripcion())
                .build()).collect(Collectors.toList());
    }
}
