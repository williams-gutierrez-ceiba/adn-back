package com.ceiba.archivo.puerto.dao;

import com.ceiba.archivo.modelo.dto.DtoArchivo;

import java.util.List;

public interface DaoArchivo {

    /**
     * Permite listar los archivos
     * @return lista de archivos
     */
    List<DtoArchivo> listar();

    /**
     * Permite listar los archivos
     * pertenecientes a una vivienda
     *
     * @param viviendaId
     * @return lista de archivos
     */
    List<DtoArchivo> listarPorViviendaId(Long viviendaId);
}
