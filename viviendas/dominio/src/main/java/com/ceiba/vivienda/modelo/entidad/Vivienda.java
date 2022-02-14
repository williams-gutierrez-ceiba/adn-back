package com.ceiba.vivienda.modelo.entidad;

import lombok.Getter;

@Getter
public class Vivienda {

    private Long id;
    private int tipoVivienda;
    private int aireAcondicionado;
    private int admiteMascotas;
    private int calefaccion;
    private int numeroHabitaciones;
    private int numeroBanios;
    private int numeroPersonas;
    private String ciudad;
    private String departamento;

}
