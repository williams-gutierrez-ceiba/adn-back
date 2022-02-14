package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCalcularValorTotalReservaTest {

    @Test
    @DisplayName("Calcular total sin fines de semana ni descuentos")
    void calcularSinDiasEnFinDeSemanaYSinDescuentos() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-01"))
                .conFechaFin(LocalDate.parse("2022-02-04"))
                .conValorParcial(BigDecimal.valueOf(200000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(false);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(800000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular total sin fines de semana, pero con descuentos")
    void calcularSinDiasEnFinDeSemanaPeroConDescuento() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-01"))
                .conFechaFin(LocalDate.parse("2022-02-04"))
                .conValorParcial(BigDecimal.valueOf(200000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(true);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(720000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular total con fines de semana, pero sin descuento")
    void calcularConDiasEnFinDeSemanaPeroSinDescuento() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-12"))
                .conFechaFin(LocalDate.parse("2022-02-13"))
                .conValorParcial(BigDecimal.valueOf(200000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(false);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(800000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular total con fines de semana, pero con descuento")
    void calcularConDiasEnFinDeSemanaPeroConDescuento() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-12"))
                .conFechaFin(LocalDate.parse("2022-02-13"))
                .conValorParcial(BigDecimal.valueOf(200000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(true);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(720000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular total con fines de semana y laborales, sin descuento")
    void calcularConDiasEnFinDeSemanaYLaboralesSinDescuento() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-14"))
                .conFechaFin(LocalDate.parse("2022-02-20"))
                .conValorParcial(BigDecimal.valueOf(10000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(false);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(90000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular total con fines de semana y laborales, con descuento")
    void calcularConDiasEnFinDeSemanaYLaboralesConDescuento() {
        // given - arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicio(LocalDate.parse("2022-02-14"))
                .conFechaFin(LocalDate.parse("2022-02-20"))
                .conValorParcial(BigDecimal.valueOf(10000))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorUsuarioId(Mockito.anyString())).thenReturn(true);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        Reserva result = servicioCalcularValorTotalReserva.ejecutar(reserva);
        // then - assert
        assertEquals(BigDecimal.valueOf(81000), result.getValorTotal());
    }

    @Test
    @DisplayName("Calcular descuento del 10%")
    void calcularDescuentoDelDiezPorciento() {
        // given - arrange
        BigDecimal valor = BigDecimal.valueOf(200000);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva =
                new ServicioCalcularValorTotalReserva(repositorioReserva);
        // when - act
        BigDecimal result = servicioCalcularValorTotalReserva.calcularDescuentoDelDiezPorciento(valor);
        // then - assert
        assertEquals(BigDecimal.valueOf(20000), result);
    }

}