package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.SemanaAloneDto;
import com.fisi.classroom.app.models.dto.TareaDto;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;

import javax.swing.text.TabExpander;
import java.util.List;

public interface ITareaService {
    public List<Tarea> findAll();
    public Tarea save(Tarea tarea);
    public List<Tarea> saveAll(List<Tarea> tareas);

    public Tarea updateTarea(TareaDto dto);
}
