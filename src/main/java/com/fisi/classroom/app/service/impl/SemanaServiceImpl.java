package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.dto.MaterialDto;
import com.fisi.classroom.app.models.dto.SemanaAloneDto;
import com.fisi.classroom.app.models.dto.SemanaDto;

import com.fisi.classroom.app.models.dto.TareaDto;
import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Material;
import com.fisi.classroom.app.models.entity.Semana;
import com.fisi.classroom.app.models.entity.Tarea;
import com.fisi.classroom.app.repository.CursoRepository;
import com.fisi.classroom.app.repository.MaterialRepository;
import com.fisi.classroom.app.repository.SemanaRepository;
import com.fisi.classroom.app.repository.TareaRepository;

import com.fisi.classroom.app.service.IMaterialService;
import com.fisi.classroom.app.service.ISemanaService;
import com.fisi.classroom.app.service.ITareaService;
import com.fisi.classroom.app.util.MaterialConvert;
import com.fisi.classroom.app.util.TareaConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemanaServiceImpl implements ISemanaService {

    @Autowired
    private SemanaRepository semanaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private TareaConvert tareaConvert;

    @Autowired
    private ITareaService tareaService;

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private MaterialConvert materialConvert;


    @Override
    public List<SemanaDto> findAllWeeks(String nombrecurso) {
        Curso curso1 = cursoRepository.findByNombrecurso(nombrecurso);
        List<SemanaDto> semanas_curso = new ArrayList<>();
        List<Semana> semanas = semanaRepository.findAllByCursoid(curso1.getId_curso());

        semanas.stream().forEach(semana -> {
            List<TareaDto> dto_tareas = new ArrayList<>();
            List<Tarea> tareas_semana = tareaRepository.findAllBySemanaid(semana);
            tareas_semana.stream().forEach(tarea -> {
                TareaDto tareaDto = TareaDto.builder()
                        .tareaid(tarea.getTareaid())
                        .descripcion(tarea.getDescripcion())
                        .nota(tarea.getNota())
                        .build();

                dto_tareas.add(tareaDto);
            });
            List<MaterialDto> dto_material = new ArrayList<>();
            List<Material> materiales_semana = materialRepository.findAllBySemanaid(semana);
            materiales_semana.stream().forEach(material -> {
                MaterialDto materialDto = MaterialDto.builder()
                        .materialid(material.getMaterialid())
                        .tipo(material.getTipo())
                        .descripcion(material.getDescripcion())
                        .url(material.getURL())
                        .build();

                dto_material.add(materialDto);
            });

            SemanaDto dto = SemanaDto.builder()
                    .numerosemana(semana.getNumerosemana())
                    .tema(semana.getTema())
                    .descripcion(semana.getDescripcion())
                    .tareas(dto_tareas)
                    .materiales(dto_material)
                    .build();
            semanas_curso.add(dto);
        });
        return semanas_curso;
    }

    @Override
    public List<SemanaAloneDto> findAllWeeksAlone(String nombrecurso) {
        Curso curso1 = cursoRepository.findByNombrecurso(nombrecurso);
        List<SemanaAloneDto> semanas_cursoAlone = new ArrayList<>();
        List<Semana> semanas = semanaRepository.findAllByCursoid(curso1.getId_curso());

        semanas.stream().forEach(semana -> {
            SemanaAloneDto dto = SemanaAloneDto.builder()
                    .semanaid(semana.getSemanaid())
                    .numerosemana(semana.getNumerosemana())
                    .tema(semana.getTema())
                    .descripcion(semana.getDescripcion())
                    .build();
            semanas_cursoAlone.add(dto);
        });
        return semanas_cursoAlone;
    }
    @Override
    public Semana createSemana(SemanaDto dto){
        Semana semana = new Semana();
        semana.setCursoid(dto.getIdcurso());
        semana.setNumerosemana(dto.getNumerosemana());
        semana.setTema(dto.getTema());
        semana.setDescripcion(dto.getDescripcion());
        Semana saveSemana = semanaRepository.save(semana);
        List<Tarea> tareas = tareaConvert.convertTarea(dto.getTareas(),saveSemana);
        List<Material> materials = materialConvert.convertMaterial(dto.getMateriales(),saveSemana);
        tareaService.saveAll(tareas);
        materialService.saveAll(materials);
        return saveSemana;
    }

    @Override
    public Semana updateSemana(SemanaAloneDto dto){
        Semana semana = semanaRepository.findById(dto.getSemanaid()).orElse(null);
        if(semana == null){
            throw new RuntimeException("La semana no fue encontrada");
        }

        semana.setNumerosemana(dto.getNumerosemana());
        semana.setTema(dto.getTema());
        semana.setDescripcion(dto.getDescripcion());

        Semana updateSemana = semanaRepository.save(semana);

        return updateSemana;

    }

    @Override
    public Integer getLastCodeSemana(){
        List<Integer> semanas = semanaRepository.getLastCodeSemana();
        return semanas.get(0);
    }


}
