package com.ceiba.archivo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.archivo.servicio.testdatabuilder.ArchivoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.archivo.modelo.entidad.Archivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArchivoTest {

    @Test
    @DisplayName("Debería crear correctamente un archivo")
    void deberiaCrearCorrectamenteElArchivo() {

        Archivo archivo = new ArchivoTestDataBuilder().build();

        assertEquals(1L, archivo.getId());
        assertEquals(1L, archivo.getViviendaId());
        assertTrue(!archivo.getRuta().isEmpty());

    }

    @Test
    @DisplayName("Debería fallar sin identificador de la vivienda")
    void deberiaFallarSinViviendaId() {
        ArchivoTestDataBuilder archivoTestDataBuilder = new ArchivoTestDataBuilder().conViviendaId(null).conId(1L);

        BasePrueba.assertThrows(() -> {
                archivoTestDataBuilder.build();
            },
            ExcepcionValorObligatorio.class, "Se debe ingresar el identificador de la vivienda");
    }

    @Test
    @DisplayName("Debería fallar sin ruta del archivo")
    void deberiaFallarSinRutaDelArchivo() {
        ArchivoTestDataBuilder archivoTestDataBuilder = new ArchivoTestDataBuilder().conRuta(null).conId(1L);

        BasePrueba.assertThrows(() -> {
                    archivoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la ruta del archivo");
    }

}
