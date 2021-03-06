package com.ceiba.reserva.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateUtil {

    public LocalDateUtil() throws IllegalAccessException {
        throw new IllegalAccessException("Clase utilitaria");
    }

    public static int calcularDiasDeFinDeSemanaEntreFechas(LocalDate inicio, LocalDate fin) {
        int diasFinDeSemana = 0;
        LocalDate fechaFin = fin.plusDays(1);
        for ( LocalDate fecha = inicio; fecha.isBefore(fechaFin); fecha = fecha.plusDays(1) ) {
            if ( fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY ) {
                ++diasFinDeSemana;
            }
        }

        return diasFinDeSemana;
    }

    public static int calcularDiasLaboralesEntreFechas(LocalDate inicio, LocalDate fin) {
        int diasLaborales = 0;
        LocalDate fechaFin = fin.plusDays(1);
        for ( LocalDate fecha = inicio; fecha.isBefore(fechaFin); fecha = fecha.plusDays(1) ) {
            if ( !(fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) ) {
                ++diasLaborales;
            }
        }

        return diasLaborales;
    }

}
