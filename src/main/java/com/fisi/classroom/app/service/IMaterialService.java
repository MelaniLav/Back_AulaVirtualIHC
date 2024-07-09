package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.SemanaAloneDto;
import com.fisi.classroom.app.models.entity.Material;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;

import java.util.List;

public interface IMaterialService {
    public List<Material> findAll();
    public Material save(Material material);
    public List<Material> saveAll(List<Material> materiales);

    public Material updateMaterial(MaterialDto dto);
}
