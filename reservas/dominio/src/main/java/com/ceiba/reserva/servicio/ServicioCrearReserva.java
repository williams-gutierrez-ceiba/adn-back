package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;
    private final ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda;
    private final ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva,
                                ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda,
                                ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva) {
        this.repositorioReserva = repositorioReserva;
        this.servicioValidarDisponibilidadVivienda = servicioValidarDisponibilidadVivienda;
        this.servicioCalcularValorTotalReserva = servicioCalcularValorTotalReserva;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        this.servicioValidarDisponibilidadVivienda.ejecutar(reserva.getViviendaId(), reserva.getFechaInicio());
        Reserva reservaConValorTotal = servicioCalcularValorTotalReserva.ejecutar(reserva);

        return this.repositorioReserva.crear(reservaConValorTotal);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
