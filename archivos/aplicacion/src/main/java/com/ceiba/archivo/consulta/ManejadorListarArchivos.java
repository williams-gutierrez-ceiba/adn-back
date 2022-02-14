package com.ceiba.archivo.consulta;

import com.ceiba.archivo.modelo.dto.DtoArchivo;
import com.ceiba.archivo.puerto.dao.DaoArchivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarArchivos {

    private final DaoArchivo daoArchivo;

    public ManejadorListarArchivos(DaoArchivo daoArchivo) {
        this.daoArchivo = daoArchivo;
    }

    public List<DtoArchivo> ejecutar() {
        return this.daoArchivo.listar();
    }
}
