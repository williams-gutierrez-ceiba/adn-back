package com.ceiba.vivienda.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vivienda.modelo.dto.DtoVivienda;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoVivienda implements RowMapper<DtoVivienda>, MapperResult {

    @Override
    public DtoVivienda mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        int tipoVivienda = resultSet.getInt("tipo_vivienda_id");
        BigDecimal costoDiario = null;
        int aireAcondicionado  = resultSet.getInt("aire_acondicionado");
        int admiteMascotas  = resultSet.getInt("mascotas");
        int calefaccion  = resultSet.getInt("calefaccion");
        int numeroHabitaciones  = resultSet.getInt("numero_habitaciones");
        int numeroBanios  = resultSet.getInt("numero_banios");
        int numeroPersonas  = resultSet.getInt("numero_personas");
        String ciudad = resultSet.getString("ciudad");
        String departamento = resultSet.getString("departamento");

        return new DtoVivienda(
              id,
              tipoVivienda,
              costoDiario,
              aireAcondicionado,
              admiteMascotas,
              calefaccion,
              numeroHabitaciones,
              numeroBanios,
              numeroPersonas,
              ciudad,
              departamento
        );
    }

}
