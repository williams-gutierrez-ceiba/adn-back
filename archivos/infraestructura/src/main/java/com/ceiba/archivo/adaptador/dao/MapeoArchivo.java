package com.ceiba.archivo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.archivo.modelo.dto.DtoArchivo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoArchivo implements RowMapper<DtoArchivo>, MapperResult {

    @Override
    public DtoArchivo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long viviendaId = resultSet.getLong("vivienda_id");
        String ruta = resultSet.getString("ruta");

        return new DtoArchivo(id, viviendaId, ruta);
    }

}
