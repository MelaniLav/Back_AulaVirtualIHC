package com.fisi.classroom.app.controllers;

import com.fisi.classroom.app.exception.InvalidDataException;
import com.fisi.classroom.app.exception.ResourseNotFoundException;
import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.dto.SemanaDto;
import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.MaterialExtraDTO;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Profesor;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.repository.AlumnoRepository;
import com.fisi.classroom.app.repository.ProfesorRepository;
import com.fisi.classroom.app.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController

@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @Autowired
    private IProfesorService profesorService;

    @Autowired
    private ISemanaService semanaService;

    private static final Logger logger = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;


    @Autowired
    private IMaterialEService materialEService;

    @Autowired
    private ICuentaService cuentaService;


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

    @PostMapping("/guardar-semana")
    public ResponseEntity<Semana> createSemana(@RequestBody SemanaDto dto){
        try{
            Semana semana = semanaService.createSemana(dto);
            return ResponseEntity.ok(semana);
        }catch (ResourseNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (InvalidDataException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/lastCodeSem")
    public Integer getLastCodeSemana(){
        return semanaService.getLastCodeSemana();
    }

    @GetMapping("/{correo}/cursos")
    public ResponseEntity<List<CursoDTO>> getCursosByAlumnoId(@PathVariable String correo){
        List<CursoDTO> cursoDTOS = alumnoRepository.findCursosByAlumnoId(correo);
    return ResponseEntity.ok(cursoDTOS);
    }

    @GetMapping("/profesor/{correo}")
    public ResponseEntity<List<CursoDTO>> getCursoProfesorId(@PathVariable String correo){
        List<CursoDTO> cursoDTOS = profesorRepository.findCursosByProfesorEmail(correo);
        return ResponseEntity.ok(cursoDTOS);
    }

    @GetMapping("/vercursos/{email}")
    public ResponseEntity<List<CursoDTO>> getCursosByUsuario(@PathVariable String email){
        List<CursoDTO> cursoDTOS = cursoService.listarCursosDtoPorUsuario(email);
        return ResponseEntity.ok(cursoDTOS);
    }

    @GetMapping("/{email}/rol")
    public ResponseEntity<String> getRol(@PathVariable String email){
        return ResponseEntity.ok(cuentaService.getRol(email));
    }

    @GetMapping("/{email}/nombre")
    public ResponseEntity<String> getName(@PathVariable String email){
        return ResponseEntity.ok(cuentaService.getName(email));
    }
}
