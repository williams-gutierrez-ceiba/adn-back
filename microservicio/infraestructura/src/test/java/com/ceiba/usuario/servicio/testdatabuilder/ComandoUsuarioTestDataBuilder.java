package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String telefonoCelular;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String tipoDocumento;
    private String numeroDocumento;

    public ComandoUsuarioTestDataBuilder() {
        telefonoCelular = "1234";
        nombres = "Jhon";
        apellidos = "Doe";
        correoElectronico = "test@test.com";
        tipoDocumento = "CC";
        numeroDocumento = "1234";
    }

    public ComandoUsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(
                id,
                telefonoCelular,
                nombres,
                apellidos,
                correoElectronico,
                tipoDocumento,
                numeroDocumento
        );
    }

//    private Long id;
//    private String nombre;
//    private String clave;
//    private LocalDateTime fecha;
//
//    public ComandoUsuarioTestDataBuilder() {
//        nombre = UUID.randomUUID().toString();
//        clave = "1234";
//        fecha = LocalDateTime.now();
//    }
//
//    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
//        this.nombre = nombre;
//        return this;
//    }
//
//    public ComandoUsuario build() {
//        return new ComandoUsuario(id,nombre, clave,fecha);
//    }
}
