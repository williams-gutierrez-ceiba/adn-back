package com.ceiba.tipo.adaptador;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipo.modelo.dto.DtoTipoVivienda;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoVivienda implements RowMapper<DtoTipoVivienda>, MapperResult {

    @Override
    public DtoTipoVivienda mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        BigDecimal costoDiario = resultSet.getBigDecimal("costo_diario");

        return new DtoTipoVivienda(id,nombre,costoDiario);
    }

}
