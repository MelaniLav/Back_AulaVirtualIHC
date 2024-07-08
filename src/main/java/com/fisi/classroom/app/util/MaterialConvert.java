package com.fisi.classroom.app.util;

import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.TareaDto;
import com.fisi.classroom.app.models.entity.Material;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialConvert {
    public List<Material> convertMaterial(List<MaterialDto> materialdto, Semana semana){
        return materialdto.stream().map(dto -> Material.builder()
                .semanaid(semana)
                .tipo(dto.getTipo())
                .descripcion(dto.getDescripcion())
                .URL(dto.getUrl())
                .build()).collect(Collectors.toList());
    }
}
