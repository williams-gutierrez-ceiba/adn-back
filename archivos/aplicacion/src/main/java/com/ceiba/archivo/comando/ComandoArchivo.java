package com.ceiba.archivo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoArchivo {

    private Long id;
    private Long viviendaId;
    private String ruta;

}
