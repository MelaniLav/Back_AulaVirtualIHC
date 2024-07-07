package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.repository.CursoRepository;
import com.fisi.classroom.app.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {
    @Autowired
    private CursoRepository cursoDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) cursoDAO.findAll();
    }

    @Override
    public List<CursoDTO> listarCursos(){
        List<CursoDTO> cursos_lista = new ArrayList<>();
        List<Curso> cur = cursoDAO.findAll();
        for(Curso curso: cur){
            CursoDTO dto = new CursoDTO();
            dto.setNombrecurso(curso.getNombrecurso());
            dto.setProfesorid(curso.getId_profesor().getId_profesor());
            dto.setNombre_profesor(curso.getId_profesor().getNombre_profesor());
            dto.setCiclo(curso.getCiclo());
            dto.setCreditos(curso.getCreditos());
            dto.setHorario(curso.getHorario());
            dto.setId_curso(curso.getId_curso());
            cursos_lista.add(dto);
        }
        return cursos_lista;
    }

    @Override
    public List<java.lang.String> listarNombres() {
        return cursoDAO.listarNombres();
    }

    @Override
    public CursoDTO findByNombre_curso(java.lang.String nombre_curso) {
        Curso curso = cursoDAO.findByNombrecurso(nombre_curso);
        return CursoDTO.builder()
                .ciclo(curso.getCiclo())
                .nombre_profesor(curso.getId_profesor().getNombre_profesor())
                .horario(curso.getHorario())
                .nombrecurso(curso.getNombrecurso())
                .build();
    }
}
