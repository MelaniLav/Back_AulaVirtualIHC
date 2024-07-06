package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {

    @Query("select c.nombrecurso from Curso c")
    List<String> listarNombres();

    Curso findByNombrecurso(java.lang.String nombre_curso);
}
