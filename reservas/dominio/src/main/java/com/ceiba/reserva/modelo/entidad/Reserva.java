package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Reserva {

    private Long id;
    private String usuarioId;
    private Long viviendaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal valorParcial;
    private BigDecimal valorTotal;

    private static final String SE_DEBE_INGRESAR_EL_IDENTIFICADOR_DE_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_EL_IDENTIFICADOR_DE_LA_VIVIENDA = "Se debe ingresar el id de la vivienda";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_FIN = "Se debe ingresar la fecha de finalización";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_PARCIAL = "Se debe ingresar el valor parcial de la reserva";

    public Reserva(Long id, String usuarioId, Long viviendaId, LocalDate fechaInicio,
                   LocalDate fechaFin, BigDecimal valorParcial, BigDecimal valorTotal) {
        validarObligatorio(usuarioId, SE_DEBE_INGRESAR_EL_IDENTIFICADOR_DE_USUARIO);
        validarObligatorio(viviendaId, SE_DEBE_INGRESAR_EL_IDENTIFICADOR_DE_LA_VIVIENDA);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_DE_INICIO);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_DE_FIN);
        validarObligatorio(valorParcial, SE_DEBE_INGRESAR_EL_VALOR_PARCIAL);

        this.id = id;
        this.usuarioId = usuarioId;
        this.viviendaId = viviendaId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorParcial = valorParcial;
        this.valorTotal = valorTotal;
    }
}
