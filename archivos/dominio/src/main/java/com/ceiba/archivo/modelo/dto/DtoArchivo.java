package com.ceiba.archivo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoArchivo {
    private Long id;
    private Long viviendaId;
    private String ruta;
}
