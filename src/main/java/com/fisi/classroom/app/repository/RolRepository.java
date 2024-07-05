package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
}
