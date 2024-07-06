package com.fisi.classroom.app.controllers;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.MaterialExtraDTO;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Profesor;
import com.fisi.classroom.app.service.ICursoService;
import com.fisi.classroom.app.service.IMaterialEService;
import com.fisi.classroom.app.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @Autowired
    private IProfesorService profesorService;
    @Autowired
    private IMaterialEService materialEService;

    @GetMapping("/listar")
    public List<Curso> listarCursos(){
        return (List<Curso>) cursoService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listar/dto")
    public List<CursoDTO> listarCursosDto(){
        return (List<CursoDTO>) cursoService.listarCursos();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/foto")
    public ResponseEntity<byte[]> obtenerFoto(@PathVariable Integer id){
        Profesor profesor = profesorService.getProfesor(id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(profesor.getFoto());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listaMaterialesE")
    public List<MaterialExtraDTO> listarMaterialesExtra(){
        return (List<MaterialExtraDTO>) materialEService.listarMaterialesExtra();
    }
}
