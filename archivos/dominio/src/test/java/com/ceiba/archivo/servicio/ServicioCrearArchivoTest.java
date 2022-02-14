package com.ceiba.archivo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.archivo.servicio.testdatabuilder.ArchivoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearArchivoTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Archivo")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelArchivo() {
        // arrange
        Archivo archivo = new ArchivoTestDataBuilder().build();
        RepositorioArchivo repositorioArchivo = Mockito.mock(RepositorioArchivo.class);
        Mockito.when(repositorioArchivo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearArchivo servicioCrearArchivo = new ServicioCrearArchivo(repositorioArchivo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearArchivo.ejecutar(archivo), ExcepcionDuplicidad.class,"El archivo ya existe en el sistema");
    }


    @Test
    @DisplayName("Deberia Crear el archivo de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        Archivo archivo = new ArchivoTestDataBuilder().build();
        RepositorioArchivo repositorioArchivo = Mockito.mock(RepositorioArchivo.class);
        Mockito.when(repositorioArchivo.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioArchivo.crear(archivo)).thenReturn(10L);
        ServicioCrearArchivo servicioCrearArchivo = new ServicioCrearArchivo(repositorioArchivo);

        Long idArchivo = servicioCrearArchivo.ejecutar(archivo);

        assertEquals(10L, idArchivo);
        Mockito.verify(repositorioArchivo, Mockito.times(1)).crear(archivo);
    }

}
