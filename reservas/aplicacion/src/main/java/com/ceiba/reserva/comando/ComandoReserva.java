package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id;
    private String usuarioId;
    private Long viviendaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal valorParcial;
    private BigDecimal valorTotal;

}
