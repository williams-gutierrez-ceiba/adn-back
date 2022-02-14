package com.ceiba.reserva.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalDateUtilTest {

    @Test
    @DisplayName("Calcular dias en fin de semana")
    void calcularDiasDeFinDeSemanaEntreFechas() {
        // given - arrange
        LocalDate fechaInicio = LocalDate.parse("2022-02-04");
        LocalDate fechaFin = LocalDate.parse("2022-02-06");
        int diasFinDeSemana = 2;
        // when - act
        int result = LocalDateUtil.calcularDiasDeFinDeSemanaEntreFechas(fechaInicio, fechaFin);
        // then - assert
        assertEquals(diasFinDeSemana, result);
    }

    @Test
    @DisplayName("Calcular dias laborales")
    void calcularDiasLaboralesEntreFechas() {
        // given - arrange
        LocalDate fechaInicio = LocalDate.parse("2022-02-01");
        LocalDate fechaFin = LocalDate.parse("2022-02-11");
        int diasLaborales = 9;
        // when - act
        int result = LocalDateUtil.calcularDiasLaboralesEntreFechas(fechaInicio, fechaFin);
        // then - assert
        assertEquals(diasLaborales, result);

    }
}