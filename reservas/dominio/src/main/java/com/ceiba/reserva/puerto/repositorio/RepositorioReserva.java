package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;

public interface RepositorioReserva {

    /**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una reserva
     * asociada a un usuario
     * @param usuarioId
     * @return si existe o no
     */
    boolean existePorUsuarioId(String usuarioId);

    /**
     * Permite validar si una
     * reserva ya existe
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite consultar si hay una reserva
     * para una vivienda y una fecha en específico
     * @param viviendaId
     * @param fechaInicio
     * @return si existe o no
     */
    boolean existeParaViviendaYFechaInicio(Long viviendaId, LocalDate fechaInicio);
}
