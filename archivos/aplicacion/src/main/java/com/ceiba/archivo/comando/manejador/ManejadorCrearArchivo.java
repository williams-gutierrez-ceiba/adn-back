package com.ceiba.archivo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.archivo.comando.ComandoArchivo;
import com.ceiba.archivo.comando.fabrica.FabricaArchivo;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.servicio.ServicioCrearArchivo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearArchivo {

    private final FabricaArchivo fabricaArchivo;
    private final ServicioCrearArchivo servicioCrearArchivo;

    public ManejadorCrearArchivo(FabricaArchivo fabricaArchivo, ServicioCrearArchivo servicioCrearArchivo) {
        this.fabricaArchivo = fabricaArchivo;
        this.servicioCrearArchivo = servicioCrearArchivo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoArchivo comandoArchivo) {
        Archivo archivo = this.fabricaArchivo.crear(comandoArchivo);
        return new ComandoRespuesta<>(this.servicioCrearArchivo.ejecutar(archivo));
    }

}
