package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.SemanaDto;
import com.fisi.classroom.app.models.entity.Semana;

import java.util.List;

public interface ISemanaService {


    public List<SemanaDto> findAllByCurso(Integer id);
}
