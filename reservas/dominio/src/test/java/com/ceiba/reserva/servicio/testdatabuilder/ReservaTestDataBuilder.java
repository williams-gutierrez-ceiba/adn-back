package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaTestDataBuilder {

    private Long id;
    private String usuarioId;
    private Long viviendaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal valorParcial;
    private BigDecimal valorTotal;

    public ReservaTestDataBuilder() {
        this.id = 1L;
        this.usuarioId = "+573125259929";
        this.viviendaId = 1L;
        this.fechaInicio = LocalDate.parse("2022-02-01");
        this.fechaFin = LocalDate.parse("2022-02-01");
        this.valorParcial = BigDecimal.valueOf(100000);
        this.valorTotal = BigDecimal.ZERO;
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public ReservaTestDataBuilder conViviendaId(Long viviendaId) {
        this.viviendaId = viviendaId;
        return this;
    }

    public ReservaTestDataBuilder conFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public ReservaTestDataBuilder conFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public ReservaTestDataBuilder conValorParcial(BigDecimal valorParcial) {
        this.valorParcial = valorParcial;
        return this;
    }

    public ReservaTestDataBuilder conValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Reserva build() {
        return new Reserva(
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
