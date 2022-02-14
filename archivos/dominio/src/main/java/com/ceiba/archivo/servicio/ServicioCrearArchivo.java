package com.ceiba.archivo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;

public class ServicioCrearArchivo {

    private static final String EL_ARCHIVO_YA_EXISTE_EN_EL_SISTEMA = "El archivo ya existe en el sistema";

    private final RepositorioArchivo repositorioArchivo;

    public ServicioCrearArchivo(RepositorioArchivo repositorioArchivo) {
        this.repositorioArchivo = repositorioArchivo;
    }

    public Long ejecutar(Archivo archivo) {
        validarExistenciaPrevia(archivo);
        return this.repositorioArchivo.crear(archivo);
    }

    private void validarExistenciaPrevia(Archivo archivo) {
        boolean existe = this.repositorioArchivo.existePorId(archivo.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ARCHIVO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
