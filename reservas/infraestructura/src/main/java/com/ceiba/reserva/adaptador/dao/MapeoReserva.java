package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String usuarioId = resultSet.getString("usuario_id");
        Long viviendaId = resultSet.getLong("vivienda_id");
        LocalDate fechaInicio = extraerLocalDate(resultSet, "fecha_inicio");
        LocalDate fechaFin = extraerLocalDate(resultSet, "fecha_fin");
        BigDecimal valorParcial = resultSet.getBigDecimal("valor_parcial");
        BigDecimal valorTotal = resultSet.getBigDecimal("valor_total");

        return new DtoReserva(
                id,
                usuarioId,
                viviendaId,
                fechaInicio,
                fechaFin,
                valorParcial,
                valorTotal
        );
    }

}
