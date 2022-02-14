package com.ceiba.archivo.comando.manejador;

import com.ceiba.archivo.comando.ComandoArchivo;
import com.ceiba.archivo.comando.fabrica.FabricaArchivo;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.servicio.ServicioActualizarArchivo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarArchivo implements ManejadorComando<ComandoArchivo> {

    private final FabricaArchivo fabricaArchivo;
    private final ServicioActualizarArchivo servicioActualizarArchivo;

    public ManejadorActualizarArchivo(FabricaArchivo fabricaArchivo, ServicioActualizarArchivo servicioActualizarArchivo) {
        this.fabricaArchivo = fabricaArchivo;
        this.servicioActualizarArchivo = servicioActualizarArchivo;
    }

    @Override
    public void ejecutar(ComandoArchivo comandoArchivo) {
        Archivo archivo = this.fabricaArchivo.crear(comandoArchivo);
        this.servicioActualizarArchivo.ejecutar(archivo);
    }
}
