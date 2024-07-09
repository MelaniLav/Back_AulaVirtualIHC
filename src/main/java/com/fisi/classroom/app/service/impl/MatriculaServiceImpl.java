package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.AlumnoDTO;
import com.fisi.classroom.app.repository.MatriculaRepository;
import com.fisi.classroom.app.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<AlumnoDTO> getCorreosByCurso(String idCurso) {
        return matriculaRepository.findCorreosByCurso(idCurso);
    }
}
