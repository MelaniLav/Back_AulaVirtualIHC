package com.fisi.classroom.app.models.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDTO {
    private String nombre_curso;
    private String nombre_profesor;
    private Integer profesorid;
    private byte[] foto;
    private String ciclo;
    private Integer creditos;
    private String horario;
    private String id_curso;
}
