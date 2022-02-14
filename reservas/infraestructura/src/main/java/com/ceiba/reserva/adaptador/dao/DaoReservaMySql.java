package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReservaMySql implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlListarPorUsuarioId = "select id, usuario_id, vivienda_id, fecha_inicio, fecha_fin, " +
            "valor_parcial, valor_total from reserva where usuario_id = :usuarioId";

    public DaoReservaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listarPorUsuarioId(String usuarioId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuarioId", usuarioId);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().query(
                        sqlListarPorUsuarioId,
                        paramSource,
                        new MapeoReserva());
    }

}
