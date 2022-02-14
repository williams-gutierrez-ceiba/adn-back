package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String telefonoCelular = resultSet.getString("TELEFONO_CELULAR");
        String nombres = resultSet.getString("NOMBRES");
        String apellidos = resultSet.getString("APELLIDOS");
        String correoElectronico = resultSet.getString("CORREO_ELECTRONICO");
        String tipoDocumento = resultSet.getString("TIPO_DOCUMENTO");
        String numeroDocumento = resultSet.getString("NUMERO_DOCUMENTO");

        return new DtoUsuario(id,telefonoCelular,nombres,apellidos,correoElectronico,
                tipoDocumento,numeroDocumento);
    }

}
