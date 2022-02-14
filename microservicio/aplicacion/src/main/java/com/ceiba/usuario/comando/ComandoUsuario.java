package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long id;
    private String telefonoCelular;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String tipoDocumento;
    private String numeroDocumento;

}
