package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String telefonoCelular;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String tipoDocumento;
    private String numeroDocumento;

    public UsuarioTestDataBuilder() {
        id = 1L;
        telefonoCelular = "1234";
        nombres = "Jhon";
        apellidos = "Doe";
        correoElectronico = "test@test.com";
        tipoDocumento = "CC";
        numeroDocumento = "1234";
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
        return this;
    }

    public UsuarioTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public UsuarioTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public UsuarioTestDataBuilder conCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
        return this;
    }

    public UsuarioTestDataBuilder conTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public UsuarioTestDataBuilder conNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public Usuario build() {
        return new Usuario(
                id,
                telefonoCelular,
                nombres,
                apellidos,
                correoElectronico,
                tipoDocumento,
                numeroDocumento
        );
    }

}
