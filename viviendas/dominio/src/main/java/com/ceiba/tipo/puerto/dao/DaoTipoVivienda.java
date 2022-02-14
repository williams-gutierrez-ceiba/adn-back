package com.ceiba.tipo.puerto.dao;

import com.ceiba.tipo.modelo.dto.DtoTipoVivienda;

public interface DaoTipoVivienda {

    /**
     * Consulta un tipo de vivienda por su identificador
     * @param id
     * @return tipo de vivienda
     */
    DtoTipoVivienda consultarPorId(Long id);

}
