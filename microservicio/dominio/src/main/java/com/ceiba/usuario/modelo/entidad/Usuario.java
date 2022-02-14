package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private Long id;
    private String telefonoCelular;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String tipoDocumento;
    private String numeroDocumento;

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO_CELULAR = "Se debe ingresar el teléfono celular";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre del usuario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_USUARIO = "Se debe ingresar el apellido del usuario";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_DEL_USUARIO = "Se debe ingresar el correo del usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DOC_DEL_USUARIO = "Se debe ingresar el tipo de doc del usuario";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DOC_DE_USUARIO = "Se debe ingresar el número de doc del usuario";

    public Usuario(Long id, String telefonoCelular, String nombres, String apellidos,
        String correoElectronico, String tipoDocumento, String numeroDocumento) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(telefonoCelular, SE_DEBE_INGRESAR_EL_TELEFONO_CELULAR);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_USUARIO);
        validarObligatorio(correoElectronico, SE_DEBE_INGRESAR_EL_CORREO_DEL_USUARIO);
        validarObligatorio(tipoDocumento, SE_DEBE_INGRESAR_EL_TIPO_DOC_DEL_USUARIO);
        validarObligatorio(numeroDocumento, SE_DEBE_INGRESAR_EL_NUMERO_DOC_DE_USUARIO);

        this.id = id;
        this.telefonoCelular = telefonoCelular;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

}
