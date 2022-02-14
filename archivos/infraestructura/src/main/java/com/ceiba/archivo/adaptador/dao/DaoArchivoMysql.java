package com.ceiba.archivo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.archivo.modelo.dto.DtoArchivo;
import com.ceiba.archivo.puerto.dao.DaoArchivo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoArchivoMysql implements DaoArchivo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

//    @SqlStatement(namespace="archivo", value="listar")
//    private static String sqlListar;
    private static String sqlListar = "select id,vivienda_id,ruta from archivo";

//    @SqlStatement(namespace="archivo", value="listarPorViviendaId")
//    private static String sqlListarPorViviendaId;
    private static String sqlListarPorViviendaId = "select id, vivienda_id, ruta from archivo where vivienda_id = :viviendaId";

    public DaoArchivoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoArchivo> listar() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(
                        sqlListar,
                        new MapeoArchivo()
                );
    }

    @Override
    public List<DtoArchivo> listarPorViviendaId(Long viviendaId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("viviendaId", viviendaId);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(
                        sqlListarPorViviendaId,
                        paramSource,
                        new MapeoArchivo()
                );
    }
}
