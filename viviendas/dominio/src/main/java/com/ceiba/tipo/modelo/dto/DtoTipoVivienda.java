package com.ceiba.tipo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoTipoVivienda {

    private Long id;
    private String name;
    private BigDecimal costoDiario;

}
