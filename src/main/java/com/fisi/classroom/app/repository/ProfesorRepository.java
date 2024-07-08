package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.dto.CursoDTO;
import com.fisi.classroom.app.models.entity.Cuenta;
import com.fisi.classroom.app.models.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {


    Profesor findByIdcuenta(Cuenta cuenta);

    @Query("SELECT DISTINCT new com.fisi.classroom.app.models.dto.CursoDTO(c.nombrecurso, p.nombre_profesor, p.id_profesor, p.foto, c.ciclo, c.creditos, c.horario, c.id_curso) " +
            "FROM Curso c " +
            "JOIN c.id_profesor p " +
            "JOIN p.idcuenta cu " +
            "WHERE cu.correo = :email")
    List<CursoDTO> findCursosByProfesorEmail(@Param("email") String email);
}
