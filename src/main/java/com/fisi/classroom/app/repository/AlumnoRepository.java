package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {

}
