package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.SemanaDto;
import com.fisi.classroom.app.repository.SemanaRepository;
import com.fisi.classroom.app.service.ISemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemanaServiceImpl implements ISemanaService {

    private SemanaRepository semanaDAO;
    @Override
    public List<SemanaDto> findAllByCurso(Integer id){
        return ( List<SemanaDto>) semanaDAO.getReferenceById(id);
    }
}
