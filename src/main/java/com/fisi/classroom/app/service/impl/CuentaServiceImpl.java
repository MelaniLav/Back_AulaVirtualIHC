package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.entity.Alumno;
import com.fisi.classroom.app.models.entity.Cuenta;
import com.fisi.classroom.app.repository.AlumnoRepository;
import com.fisi.classroom.app.repository.CuentaRepository;
import com.fisi.classroom.app.repository.ProfesorRepository;
import com.fisi.classroom.app.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements ICuentaService {


    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public String getRol(String email) {

        Cuenta cuenta = cuentaRepository.findByCorreo(email);
         return cuenta.getIdrol().getRol();
    }

    @Override
    public String getName(String email) {
        Cuenta cuenta = cuentaRepository.findByCorreo(email);
        if (cuenta.getIdrol().getRol().equals("ALUMNO_ROL")) {
            Alumno alumno = alumnoRepository.findByCuenta(cuenta);
            return alumno.getNombrealumno();
        }else {
            return profesorRepository.findByIdcuenta(cuenta).getNombre_profesor();
        }

    }
}
