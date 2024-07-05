package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.entity.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> findAll();

    public List<CursoDTO> listarCursos();
}
