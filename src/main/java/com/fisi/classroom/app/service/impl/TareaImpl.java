package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.entity.Tarea;
import com.fisi.classroom.app.repository.TareaRepository;
import com.fisi.classroom.app.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaImpl implements ITareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> findAll(){
        return tareaRepository.findAll();
    }

    @Override
    public Tarea save(Tarea tarea){
        return tareaRepository.save(tarea);
    }
    @Override
    public List<Tarea> saveAll(List<Tarea> tareas){
        return tareaRepository.saveAll(tareas);
    }
}
