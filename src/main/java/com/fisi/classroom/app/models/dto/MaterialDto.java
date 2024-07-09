package com.fisi.classroom.app.models.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialDto {
    private Integer materialid;
    private String tipo;
    private String descripcion;
    private String url;

}
