package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.LocalDate;

public class ServicioValidarDisponibilidadVivienda {

    private static final String LA_VIVIENDA_NO_ESTA_DISPONIBLE = "La vivienda no está disponible";

    private final RepositorioReserva repositorioReserva;

    public ServicioValidarDisponibilidadVivienda(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public boolean ejecutar(Long viviendaId, LocalDate fechaInicio) {
        boolean existe = this.repositorioReserva.existeParaViviendaYFechaInicio(viviendaId, fechaInicio);
        if (existe) {
            throw new ExcepcionDuplicidad(LA_VIVIENDA_NO_ESTA_DISPONIBLE);
        }
        return existe;
    }
}
