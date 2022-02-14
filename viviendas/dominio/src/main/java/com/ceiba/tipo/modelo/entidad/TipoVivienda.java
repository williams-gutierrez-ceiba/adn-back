package com.ceiba.tipo.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoVivienda {

    private Long id;
    private String name;
    private BigDecimal costoDiario;

}
