package com.ceiba.archivo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.archivo.servicio.testdatabuilder.ArchivoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarArchivoTest {

    @Test
    @DisplayName("Debería validar existencia previa")
    void deberiaValidarLaExistenciaPreviaDelArchivo() {
        // arrange
        Archivo archivo = new ArchivoTestDataBuilder().build();
        RepositorioArchivo repositorioArchivo = Mockito.mock(RepositorioArchivo.class);
        Mockito.when(repositorioArchivo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarArchivo servicioActualizarArchivo = new ServicioActualizarArchivo(repositorioArchivo);
        // act - assert
        BasePrueba.assertThrows(() ->
                servicioActualizarArchivo.ejecutar(archivo),
                ExcepcionDuplicidad.class,"El archivo no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Archivo archivo = new ArchivoTestDataBuilder().build();
        RepositorioArchivo repositorioArchivo = Mockito.mock(RepositorioArchivo.class);
        Mockito.when(repositorioArchivo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarArchivo servicioActualizarArchivo = new ServicioActualizarArchivo(repositorioArchivo);
        // act
        servicioActualizarArchivo.ejecutar(archivo);
        //assert
        Mockito.verify(repositorioArchivo,Mockito.times(1)).actualizar(archivo);
    }
}
