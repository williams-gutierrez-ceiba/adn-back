package com.ceiba.vivienda.puerto.dao;

import com.ceiba.vivienda.modelo.dto.DtoVivienda;

import java.util.List;

public interface DaoVivienda {

    /**
     * Permite listar las viviendas disponibles
     * @return lista de viviendas disponibles
     */
    public List<DtoVivienda> listar();

    /**
     * Consulta una vivienda por id
     * @param id
     * @return vivienda
     */
    DtoVivienda consultarPorId(Long id);
}
