package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearReservaTest {

    @Test
    void deberiaLanzarUnaExepcionCuandoUnaViviendaNoEsteDisponible() {
        // arrange - given
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda
                = Mockito.mock(ServicioValidarDisponibilidadVivienda.class);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva
                = Mockito.mock(ServicioCalcularValorTotalReserva.class);
        Mockito.when(servicioValidarDisponibilidadVivienda
                .ejecutar(reserva.getViviendaId(), reserva.getFechaInicio()))
                .thenThrow(new ExcepcionDuplicidad("La vivienda no está disponible"));
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(
                repositorioReserva,
                servicioValidarDisponibilidadVivienda,
                servicioCalcularValorTotalReserva);
        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearReserva.ejecutar(reserva),
                ExcepcionDuplicidad.class,
                "La vivienda no está disponible"
        );

    }

    @Test
    void deberiaCrearLaReservaDeManeraCorrecta() {
        // arrange - given
        Reserva reserva = new ReservaTestDataBuilder().conId(null).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda
                = Mockito.mock(ServicioValidarDisponibilidadVivienda.class);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva
                = Mockito.mock(ServicioCalcularValorTotalReserva.class);
        Mockito.when(servicioValidarDisponibilidadVivienda
                        .ejecutar(reserva.getViviendaId(), reserva.getFechaInicio())).thenReturn(true);
        Mockito.when(servicioCalcularValorTotalReserva.ejecutar(reserva)).thenReturn(reserva);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(10L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(
                repositorioReserva,
                servicioValidarDisponibilidadVivienda,
                servicioCalcularValorTotalReserva);
        // act - assert
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        // assert
        assertEquals(10L, idReserva);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }
}