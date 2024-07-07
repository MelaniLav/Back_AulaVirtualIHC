package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.MaterialExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialExtraRepository extends JpaRepository<MaterialExtra,Integer> {
}
