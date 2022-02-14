package com.ceiba.vivienda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class DtoVivienda {

    private Long id;
    private int tipoVivienda;
    private BigDecimal costoDiario;
    private int aireAcondicionado;
    private int admiteMascotas;
    private int calefaccion;
    private int numeroHabitaciones;
    private int numeroBanios;
    private int numeroPersonas;
    private String ciudad;
    private String departamento;

}
