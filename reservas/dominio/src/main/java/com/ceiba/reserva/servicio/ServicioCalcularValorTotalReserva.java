package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.math.BigDecimal;

import static com.ceiba.reserva.util.LocalDateUtil.calcularDiasDeFinDeSemanaEntreFechas;
import static com.ceiba.reserva.util.LocalDateUtil.calcularDiasLaboralesEntreFechas;

public class ServicioCalcularValorTotalReserva {

    private final RepositorioReserva repositorioReserva;

    public ServicioCalcularValorTotalReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(Reserva reserva) {
        BigDecimal valorDiaReserva = reserva.getValorParcial();
        // Se Valida si el usuario ya tiene una reserva, para descontar el 10%
        boolean aplicaDescuento = this.repositorioReserva.existePorUsuarioId(reserva.getUsuarioId());
        // Se calcula el número de días en fin de semana
        int diasFinDeSemana = calcularDiasDeFinDeSemanaEntreFechas(reserva.getFechaInicio(), reserva.getFechaFin());
        // Se calcula el número de días laborales
        int diasLaborales = calcularDiasLaboralesEntreFechas(reserva.getFechaInicio(), reserva.getFechaFin());
        // Se calcula el valor de los días laborales (valorDia * diasLaborales)
        BigDecimal valorDiasLaborales = valorDiaReserva.multiply(BigDecimal.valueOf(diasLaborales));
        // Se calcula el valor de los días de fin de semana ( valorDia * (diasFinDeSemana * 2) )
        BigDecimal valorDiasFinDeSemana = valorDiaReserva.multiply(BigDecimal.valueOf(diasFinDeSemana * 2L));
        // Se calcula valor total de la reserva SIN descuento
        BigDecimal subTotalReserva = valorDiasFinDeSemana.add(valorDiasLaborales);
        BigDecimal valorDescuento = BigDecimal.ZERO;
        if (aplicaDescuento) {
            //Se calcula el valor del descuento, si aplica
            valorDescuento = calcularDescuentoDelDiezPorciento(subTotalReserva);
        }
        //Se calcula el valor total de la reserva, teniendo en cuenta el descuento
        BigDecimal valorTotal = subTotalReserva.subtract(valorDescuento);
        reserva.setValorTotal(valorTotal);

        return reserva;
    }

    public BigDecimal calcularDescuentoDelDiezPorciento(BigDecimal valor) {
        // (10*100000)/100 -> el diez porciento de $100.000 son $10.000
        return ( BigDecimal.TEN.multiply(valor).divide(BigDecimal.valueOf(100)) );
    }

}
