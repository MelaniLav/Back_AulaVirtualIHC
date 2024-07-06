package com.fisi.classroom.app.controllers;

import com.fisi.classroom.app.config.JwtUtil;
import com.fisi.classroom.app.models.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println(authRequest.getCorreo()+" "+authRequest.getPassword());
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getCorreo());

            if (!authRequest.getPassword().equals(userDetails.getPassword())) {
                throw new Exception("Invalid password");
            }
        } catch (AuthenticationException e) {
            throw new Exception("Invalid username or password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getCorreo());
        String token = jwtUtil.generateToken(userDetails.getUsername());
        System.out.println(token);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
