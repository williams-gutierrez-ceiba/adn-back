package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioValidarDisponibilidadViviendaTest {

    @Test
    void deberiaLanzarUnaExepcionCuandoUnaViviendaNoEsteDisponible() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva
                .existeParaViviendaYFechaInicio(
                        reserva.getViviendaId(),
                        reserva.getFechaInicio()))
                .thenReturn(true);
        ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda
                = new ServicioValidarDisponibilidadVivienda(repositorioReserva);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioValidarDisponibilidadVivienda.ejecutar(reserva.getViviendaId(), reserva.getFechaInicio()),
                ExcepcionDuplicidad.class,
                "La vivienda no está disponible"
        );
    }

    @Test
    void deberiaDejarSeguirCuandoUnaViviendaEsteDisponible() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva
                        .existeParaViviendaYFechaInicio(
                                reserva.getViviendaId(),
                                reserva.getFechaInicio()))
                .thenReturn(false);
        ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda
                = new ServicioValidarDisponibilidadVivienda(repositorioReserva);
        // act
        boolean result = servicioValidarDisponibilidadVivienda.ejecutar(reserva.getViviendaId(),
                reserva.getFechaInicio());
        // assert
        assertEquals(false, result);
    }
}