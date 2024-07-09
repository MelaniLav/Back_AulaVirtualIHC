package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.AlumnoDTO;

import java.util.List;

public interface IMatriculaService {

    List<AlumnoDTO> getCorreosByCurso(String idCurso);
}
