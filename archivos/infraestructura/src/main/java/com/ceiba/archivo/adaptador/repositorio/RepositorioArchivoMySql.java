package com.ceiba.archivo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioArchivoMySql implements RepositorioArchivo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

//    @SqlStatement(namespace="archivo", value="crear")
    private static String sqlCrear;

//    @SqlStatement(namespace="archivo", value="actualizar")
    private static String sqlActualizar;

//    @SqlStatement(namespace="archivo", value="eliminar")
    private static String sqlEliminar;

//    @SqlStatement(namespace="archivo", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioArchivoMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Archivo archivo) {
        return this.customNamedParameterJdbcTemplate.crear(archivo, sqlCrear);
    }

    @Override
    public void actualizar(Archivo archivo) {
        this.customNamedParameterJdbcTemplate.actualizar(archivo, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
