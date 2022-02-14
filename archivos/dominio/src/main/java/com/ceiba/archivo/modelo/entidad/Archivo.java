package com.ceiba.archivo.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Archivo {

    private Long id;
    private Long viviendaId;
    private String ruta;

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_VIVIENDA = "Se debe ingresar el identificador de la vivienda";
    private static final String SE_DEBE_INGRESAR_LA_RUTA_DEL_ARCHIVO = "Se debe ingresar la ruta del archivo";

    public Archivo(Long id, Long viviendaId, String ruta) {
        validarObligatorio(viviendaId, SE_DEBE_INGRESAR_EL_ID_DE_LA_VIVIENDA);
        validarObligatorio(ruta, SE_DEBE_INGRESAR_LA_RUTA_DEL_ARCHIVO);

        this.id = id;
        this.viviendaId = viviendaId;
        this.ruta = ruta;
    }

}
