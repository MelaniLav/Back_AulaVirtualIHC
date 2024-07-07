package com.fisi.classroom.app.controllers;

import com.fisi.classroom.app.models.dto.CursoDTO;
<<<<<<< HEAD
import com.fisi.classroom.app.models.dto.SemanaDto;
=======
import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.MaterialExtraDTO;
>>>>>>> origin/ramaMelani
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Profesor;
import com.fisi.classroom.app.service.ICursoService;
import com.fisi.classroom.app.service.IMaterialEService;
import com.fisi.classroom.app.service.IProfesorService;
import com.fisi.classroom.app.service.ISemanaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
<<<<<<< HEAD

    @Autowired
    private ISemanaService semanaService;

    private static final Logger logger = LoggerFactory.getLogger(CursoController.class);


    @Autowired
    private IMaterialEService materialEService;


    @GetMapping("/listar")
    public List<Curso> listarCursos(){
        return (List<Curso>) cursoService.findAll();
    }

    @GetMapping("/listar/nombres")
    public List<java.lang.String> listarNombresCursos(){
        return cursoService.listarNombres();
    }

    @GetMapping("/buscar/{nombre_curso}")
    public CursoDTO buscarCurso(@PathVariable java.lang.String nombre_curso){
        return cursoService.findByNombre_curso(nombre_curso);
    }


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




    @GetMapping("/semanas/{curso}")
    public List<SemanaDto> getAvailableWeeks(@PathVariable String curso) {
        return semanaService.findAllWeeks(curso);
    }

    @GetMapping("/listaMaterialesE")
    public List<MaterialExtraDTO> listarMaterialesExtra(){
        return (List<MaterialExtraDTO>) materialEService.listarMaterialesExtra();

    }
}
