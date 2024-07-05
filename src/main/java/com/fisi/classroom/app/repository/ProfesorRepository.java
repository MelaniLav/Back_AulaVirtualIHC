package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
