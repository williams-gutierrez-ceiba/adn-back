package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id;
    private String usuarioId;
    private Long viviendaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal valorParcial;
    private BigDecimal valorTotal;

}
