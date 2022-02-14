package com.ceiba.tipo.consulta;

import com.ceiba.tipo.modelo.dto.DtoTipoVivienda;
import com.ceiba.tipo.puerto.dao.DaoTipoVivienda;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarPorIdTipoVivienda {

    private final DaoTipoVivienda daoTipoVivienda;

    public ManejadorConsultarPorIdTipoVivienda(DaoTipoVivienda daoTipoVivienda) {
        this.daoTipoVivienda = daoTipoVivienda;
    }

    public DtoTipoVivienda ejecutar(Long id) {
        return this.daoTipoVivienda.consultarPorId(id);
    }

}
