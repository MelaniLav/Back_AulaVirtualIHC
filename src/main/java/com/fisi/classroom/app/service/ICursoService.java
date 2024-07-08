package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.entity.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> findAll();

    public List<CursoDTO> listarCursos();

    public List<java.lang.String> listarNombres();

    public CursoDTO findByNombre_curso(java.lang.String nombre_curso);

    public List<CursoDTO> listarCursosDtoPorUsuario(String email);
}
