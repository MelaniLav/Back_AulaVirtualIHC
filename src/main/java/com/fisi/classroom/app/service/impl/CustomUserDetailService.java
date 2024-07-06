package com.fisi.classroom.app.service.impl;

import com.fisi.classroom.app.models.CustomUserDetails;
import com.fisi.classroom.app.models.entity.Cuenta;
import com.fisi.classroom.app.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cuenta cuenta = cuentaRepository.findByCorreo(username);

        if(cuenta == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new CustomUserDetails(cuenta);
    }
}
