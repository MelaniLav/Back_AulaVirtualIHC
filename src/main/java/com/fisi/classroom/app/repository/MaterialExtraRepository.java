package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.MaterialExtra;
import com.fisi.classroom.app.models.entity.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialExtraRepository extends JpaRepository<MaterialExtra,Integer> {

}
