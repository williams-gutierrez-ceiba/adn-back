package com.ceiba.archivo.servicio.testdatabuilder;

import com.ceiba.archivo.modelo.entidad.Archivo;

public class ArchivoTestDataBuilder {

    private Long id;
    private Long viviendaId;
    private String ruta;

    public ArchivoTestDataBuilder() {
        this.id = 1L;
        this.viviendaId = 1L;
        this.ruta = "src/public/images/imagen-1.jpg";
    }

    public ArchivoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ArchivoTestDataBuilder conViviendaId(Long id) {
        this.viviendaId = id;
        return this;
    }

    public ArchivoTestDataBuilder conRuta(String ruta) {
        this.ruta = ruta;
        return this;
    }

    public Archivo build() {
        return new Archivo(
                id,
                viviendaId,
                ruta
        );
    }

}
