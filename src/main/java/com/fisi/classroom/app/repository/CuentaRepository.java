package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    Cuenta findByCorreo(String correo);
}
