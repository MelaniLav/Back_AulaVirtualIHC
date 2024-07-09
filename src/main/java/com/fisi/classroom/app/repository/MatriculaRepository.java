package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.dto.AlumnoDTO;
import com.fisi.classroom.app.models.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {

    @Query("SELECT new com.fisi.classroom.app.models.dto.AlumnoDTO(a.nombrealumno, c.correo) " +
            "FROM Matricula m " +
            "JOIN m.id_alumno a " +
            "JOIN a.cuenta c " +
            "JOIN m.id_curso cu " +
            "WHERE cu.nombrecurso = :nombreCurso")
    List<AlumnoDTO> findCorreosByCurso(@Param("nombreCurso") String nombreCurso);
}
