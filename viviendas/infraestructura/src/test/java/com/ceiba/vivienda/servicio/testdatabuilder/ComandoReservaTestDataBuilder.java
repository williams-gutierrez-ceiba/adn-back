package com.ceiba.vivienda.servicio.testdatabuilder;

public class ComandoReservaTestDataBuilder {

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

    public ComandoReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

}
