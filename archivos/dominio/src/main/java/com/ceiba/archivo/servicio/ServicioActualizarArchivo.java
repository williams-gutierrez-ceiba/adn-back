package com.ceiba.archivo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.archivo.modelo.entidad.Archivo;
import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;

public class ServicioActualizarArchivo {

    private static final String EL_ARCHIVO_NO_EXISTE_EN_EL_SISTEMA = "El archivo no existe en el sistema";

    private final RepositorioArchivo repositorioArchivo;

    public ServicioActualizarArchivo(RepositorioArchivo repositorioArchivo) {
        this.repositorioArchivo = repositorioArchivo;
    }

    public void ejecutar(Archivo archivo) {
        validarExistenciaPrevia(archivo);
        this.repositorioArchivo.actualizar(archivo);
    }

    private void validarExistenciaPrevia(Archivo archivo) {
        boolean existe = this.repositorioArchivo.existePorId(archivo.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_ARCHIVO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
