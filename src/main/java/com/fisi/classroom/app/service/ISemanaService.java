package com.fisi.classroom.app.service;

import com.fisi.classroom.app.models.dto.SemanaAloneDto;
import com.fisi.classroom.app.models.dto.SemanaDto;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Semana;

import java.util.List;

public interface ISemanaService {


    public List<SemanaDto> findAllWeeks(String nombrecurso);

    public List<SemanaAloneDto> findAllWeeksAlone(String nombrecurso);

    public Semana createSemana(SemanaDto dto);

    public Semana updateSemana(SemanaAloneDto dto);

    public Integer getLastCodeSemana();
}
