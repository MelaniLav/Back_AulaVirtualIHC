package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.entity.Alumno;
import com.fisi.classroom.app.models.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {

    Alumno findByCuenta(Cuenta cuenta);

    @Query("SELECT DISTINCT new com.fisi.classroom.app.models.dto.CursoDTO(c.nombrecurso, p.nombre_profesor, p.id_profesor, p.foto, c.ciclo, c.creditos, c.horario, c.id_curso) " +
            "FROM Matricula m " +
            "JOIN m.id_alumno a " +
            "JOIN a.cuenta cu " +
            "JOIN m.id_curso c " +
            "JOIN c.id_profesor p " +
            "WHERE cu.correo = :email")
    List<CursoDTO> findCursosByAlumnoId(@Param("email") String email);

}
