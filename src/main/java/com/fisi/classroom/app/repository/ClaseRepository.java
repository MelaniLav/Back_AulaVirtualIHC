package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Clase;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Integer> {
}
