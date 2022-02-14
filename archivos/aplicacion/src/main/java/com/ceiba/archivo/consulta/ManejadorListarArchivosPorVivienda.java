package com.ceiba.archivo.consulta;

import com.ceiba.archivo.modelo.dto.DtoArchivo;
import com.ceiba.archivo.puerto.dao.DaoArchivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarArchivosPorVivienda {

    private final DaoArchivo daoArchivo;

    public ManejadorListarArchivosPorVivienda(DaoArchivo daoArchivo) {
        this.daoArchivo = daoArchivo;
    }

    public List<DtoArchivo> ejecutar(Long viviendaId) {
        return this.daoArchivo.listarPorViviendaId(viviendaId);
    }
}
