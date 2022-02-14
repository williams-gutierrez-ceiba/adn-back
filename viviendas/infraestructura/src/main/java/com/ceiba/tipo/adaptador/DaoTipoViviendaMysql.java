package com.ceiba.tipo.adaptador;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.tipo.modelo.dto.DtoTipoVivienda;
import com.ceiba.tipo.puerto.dao.DaoTipoVivienda;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoTipoViviendaMysql implements DaoTipoVivienda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlConsultarPorId =
            "select id, nombre, costo_diario from tipo_vivienda where id = :id";

    public DaoTipoViviendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoTipoVivienda consultarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(
                        sqlConsultarPorId,
                        paramSource,
                        new MapeoTipoVivienda()
                );
    }
}
