package com.fisi.classroom.app.models.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoDTO {

    private String nombreCompleto;
    private String correo;
}
