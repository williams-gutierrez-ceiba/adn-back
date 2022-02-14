package com.ceiba.vivienda.consulta;

import com.ceiba.tipo.puerto.dao.DaoTipoVivienda;
import com.ceiba.vivienda.modelo.dto.DtoVivienda;
import com.ceiba.vivienda.puerto.dao.DaoVivienda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarViviendas {

    private final DaoVivienda daoVivienda;
    private final DaoTipoVivienda daoTipoVivienda;

    public ManejadorListarViviendas(DaoVivienda daoVivienda,
                                    DaoTipoVivienda daoTipoVivienda) {
        this.daoVivienda = daoVivienda;
        this.daoTipoVivienda = daoTipoVivienda;
    }

    public List<DtoVivienda> ejecutar() {
        return this.asignarCostoDiario(this.daoVivienda.listar());
    }

    private List<DtoVivienda> asignarCostoDiario(List<DtoVivienda> viviendas) {
        for (DtoVivienda dto : viviendas) {
            dto.setCostoDiario(daoTipoVivienda.consultarPorId(new Long(dto.getTipoVivienda())).getCostoDiario());
        }
        return viviendas;
    }
}
