package com.ceiba.vivienda.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.vivienda.modelo.dto.DtoVivienda;
import com.ceiba.vivienda.puerto.dao.DaoVivienda;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoViviendaMysql implements DaoVivienda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlListar = "select id,tipo_vivienda_id,aire_acondicionado,mascotas,calefaccion," +
            "numero_habitaciones,numero_banios,numero_personas,ciudad,departamento from vivienda";
    
    private static String sqlConsultarPorId = "select id,tipo_vivienda_id,aire_acondicionado,mascotas,calefaccion," +
        "numero_habitaciones,numero_banios,numero_personas,ciudad,departamento from vivienda where id = :id";

    public DaoViviendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVivienda> listar() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(
                        sqlListar,
                        new MapeoVivienda()
                );
    }

    @Override
    public DtoVivienda consultarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(
                        sqlConsultarPorId,
                        paramSource,
                        new MapeoVivienda()
                );
    }
}
