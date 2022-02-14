package com.ceiba.archivo.comando.fabrica;

import com.ceiba.archivo.comando.ComandoArchivo;
import com.ceiba.archivo.modelo.entidad.Archivo;
import org.springframework.stereotype.Component;

@Component
public class FabricaArchivo {

    public Archivo crear(ComandoArchivo comandoArchivo) {
        return new Archivo(
                comandoArchivo.getId(),
                comandoArchivo.getViviendaId(),
                comandoArchivo.getRuta()
        );
    }

}
