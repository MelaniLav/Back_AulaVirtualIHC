package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.entity.Tarea;

import java.util.List;

public interface ITareaService {
    public List<Tarea> findAll();
    public Tarea save(Tarea tarea);
    public List<Tarea> saveAll(List<Tarea> tareas);
}
