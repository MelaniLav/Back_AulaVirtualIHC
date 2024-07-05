package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.entity.Profesor;
import org.springframework.http.ResponseEntity;

public interface IProfesorService {

    public Profesor getProfesor(Integer id);
}
