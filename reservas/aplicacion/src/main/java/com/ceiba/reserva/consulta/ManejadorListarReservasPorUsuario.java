package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservasPorUsuario {

    private final DaoReserva daoReserva;

    public ManejadorListarReservasPorUsuario(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(String usuarioId) {
        return this.daoReserva.listarPorUsuarioId(usuarioId);
    }
}
