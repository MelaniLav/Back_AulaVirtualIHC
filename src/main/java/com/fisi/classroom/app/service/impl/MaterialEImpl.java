package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.dto.MaterialExtraDTO;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.MaterialExtra;
import com.fisi.classroom.app.repository.MaterialExtraRepository;
import com.fisi.classroom.app.service.IMaterialEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialEImpl implements IMaterialEService {
    @Autowired
    private MaterialExtraRepository materialExtraRepository;

    @Override
    public List<MaterialExtraDTO> listarMaterialesExtra(){
        List<MaterialExtraDTO> materiales_lista = new ArrayList<>();
        List<MaterialExtra> mat = materialExtraRepository.findAll();
        for(MaterialExtra material: mat){
            MaterialExtraDTO dto = new MaterialExtraDTO();
            dto.setMaterialextraid(material.getMaterialextraid());
            dto.setCursoid(material.getCursoid().getId_curso());
            dto.setTipo(material.getTipo());
            dto.setDescripcion(material.getDescripcion());
            dto.setRuta(material.getURL());
            materiales_lista.add(dto);
        }
        return materiales_lista;
    }
}
