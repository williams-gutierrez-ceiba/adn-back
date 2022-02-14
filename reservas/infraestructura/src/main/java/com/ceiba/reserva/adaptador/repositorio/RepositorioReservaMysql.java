package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.reserva.adaptador.dao.MapeoReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlCrear = "insert into reserva (usuario_id, vivienda_id, fecha_inicio, fecha_fin, " +
            "valor_parcial, valor_total) values (:usuarioId, :viviendaId, :fechaInicio, " +
            ":fechaFin, :valorParcial, :valorTotal)";

    private static String sqlEliminar = "delete from reserva where id = :id";

    private static String sqlExistePorUsuario = "select count(1) from reserva where usuario_id = :usuarioId";

    private static String sqlExiste = "select count(1) from reserva where id = :id";

    private static String sqlExistePorViviendaYFecha = "select id, usuario_id, vivienda_id, fecha_inicio, fecha_fin, " +
            "valor_parcial, valor_total from reserva where vivienda_id = :viviendaId " +
            "and :fechaInicio between fecha_inicio and fecha_fin";

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorUsuarioId(String usuarioId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuarioId", usuarioId);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(
                        sqlExistePorUsuario,
                        paramSource,
                        Boolean.class
                );
    }

    @Override
    public boolean existe(Long id) {
        if (id==null) return false;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(
                        sqlExiste,
                        paramSource,
                        Boolean.class
                );
    }

    @Override
    public boolean existeParaViviendaYFechaInicio(Long viviendaId, LocalDate fechaInicio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("viviendaId", viviendaId);
        paramSource.addValue("fechaInicio", fechaInicio.toString());

        List<DtoReserva> reservas = this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(
                        sqlExistePorViviendaYFecha,
                        paramSource,
                        new MapeoReserva());

        if (!reservas.isEmpty()) {
            return true;
        }

        return false;
    }

}
