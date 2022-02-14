package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private String usuarioId;
    private Long viviendaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal valorParcial;
    private BigDecimal valorTotal;

    public ComandoReservaTestDataBuilder() {
        this.id = 1L;
        this.usuarioId = "32145";
        this.viviendaId = 1L;
        this.fechaInicio = LocalDate.parse("2022-02-01");
        this.fechaFin = LocalDate.parse("2022-02-01");
        this.valorParcial = BigDecimal.valueOf(100000);
        this.valorTotal = BigDecimal.ZERO;
    }

    public ComandoReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoReservaTestDataBuilder conUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public ComandoReservaTestDataBuilder conViviendaId(Long viviendaId) {
        this.viviendaId = viviendaId;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public ComandoReservaTestDataBuilder conValorParcial(BigDecimal valorParcial) {
        this.valorParcial = valorParcial;
        return this;
    }

    public ComandoReservaTestDataBuilder conValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(
                id,
                usuarioId,
                viviendaId,
                fechaInicio,
                fechaFin,
                valorParcial,
                valorTotal
        );
    }

}
