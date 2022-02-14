package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {

    private Long id;
    private String telefonoCelular;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String tipoDocumento;
    private String numeroDocumento;

}
