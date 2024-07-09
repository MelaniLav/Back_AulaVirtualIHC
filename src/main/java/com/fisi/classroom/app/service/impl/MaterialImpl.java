package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.SemanaAloneDto;
import com.fisi.classroom.app.models.entity.Material;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;
import com.fisi.classroom.app.repository.MaterialRepository;
import com.fisi.classroom.app.repository.TareaRepository;
import com.fisi.classroom.app.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialImpl implements IMaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    @Override
    public Material save(Material material){
        return materialRepository.save(material);
    }
    @Override
    public List<Material> saveAll(List<Material> materiales){
        return materialRepository.saveAll(materiales);
    }

    @Override
    public Material updateMaterial(MaterialDto dto){
        Material material = materialRepository.findById(dto.getMaterialid()).orElse(null);
        if(material == null){
            throw new RuntimeException("El material no fue encontrado");
        }

        material.setTipo(dto.getTipo());
        material.setDescripcion(dto.getDescripcion());
        material.setURL(dto.getUrl());

        Material updateMaterial = materialRepository.save(material);

        return updateMaterial;

    }
}
