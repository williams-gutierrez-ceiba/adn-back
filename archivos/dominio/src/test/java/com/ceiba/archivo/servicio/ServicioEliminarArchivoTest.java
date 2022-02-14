package com.ceiba.archivo.servicio;

import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarArchivoTest {

    @Test
    @DisplayName("Deberia eliminar el archivo llamando al repositorio")
    void deberiaEliminarElArchivoLlamandoAlRepositorio() {
        RepositorioArchivo repositorioArchivo = Mockito.mock(RepositorioArchivo.class);
        ServicioEliminarArchivo servicioEliminarArchivo = new ServicioEliminarArchivo(repositorioArchivo);

        servicioEliminarArchivo.ejecutar(1l);

        Mockito.verify(repositorioArchivo, Mockito.times(1)).eliminar(1l);

    }

}
