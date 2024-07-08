package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.entity.Material;
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
}
