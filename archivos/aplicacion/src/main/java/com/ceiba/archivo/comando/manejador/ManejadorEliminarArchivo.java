package com.ceiba.archivo.comando.manejador;

import com.ceiba.archivo.servicio.ServicioEliminarArchivo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarArchivo {

    private final ServicioEliminarArchivo servicioEliminarArchivo;

    public ManejadorEliminarArchivo(ServicioEliminarArchivo servicioEliminarArchivo) {
        this.servicioEliminarArchivo = servicioEliminarArchivo;
    }

    public void ejecutar(Long idArchivo) {
        this.servicioEliminarArchivo.ejecutar(idArchivo);
    }
}
