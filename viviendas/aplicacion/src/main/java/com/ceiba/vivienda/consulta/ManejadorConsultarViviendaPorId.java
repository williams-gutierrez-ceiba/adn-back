package com.ceiba.vivienda.consulta;

import com.ceiba.tipo.puerto.dao.DaoTipoVivienda;
import com.ceiba.vivienda.modelo.dto.DtoVivienda;
import com.ceiba.vivienda.puerto.dao.DaoVivienda;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarViviendaPorId {

    private final DaoVivienda daoVivienda;
    private final DaoTipoVivienda daoTipoVivienda;

    public ManejadorConsultarViviendaPorId(DaoVivienda daoVivienda, DaoTipoVivienda daoTipoVivienda) {
        this.daoVivienda = daoVivienda;
        this.daoTipoVivienda = daoTipoVivienda;
    }

    public DtoVivienda ejecutar (Long viviendaId) {
        return agregarCostoDiario(daoVivienda.consultarPorId(viviendaId));
    }

    private DtoVivienda agregarCostoDiario(DtoVivienda dto){
        dto.setCostoDiario(daoTipoVivienda.consultarPorId(new Long(dto.getTipoVivienda())).getCostoDiario());
        return dto;
    }
}
