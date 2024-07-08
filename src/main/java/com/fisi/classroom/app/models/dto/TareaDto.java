package com.fisi.classroom.app.models.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TareaDto {
    
    private String descripcion;
    private Float nota;
}
