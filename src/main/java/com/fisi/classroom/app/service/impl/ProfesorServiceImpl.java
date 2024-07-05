package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.entity.Profesor;
import com.fisi.classroom.app.repository.ProfesorRepository;
import com.fisi.classroom.app.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public Profesor getProfesor(Integer id){
        return  profesorRepository.findById(id).orElse(null);
    }
}
