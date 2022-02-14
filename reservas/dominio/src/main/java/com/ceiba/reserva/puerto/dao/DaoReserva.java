package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar reservas
     * asociadas a un usuario
     *
     * @param usuarioId
     * @return lista de reservas
     */
    List<DtoReserva> listarPorUsuarioId(String usuarioId);

}
