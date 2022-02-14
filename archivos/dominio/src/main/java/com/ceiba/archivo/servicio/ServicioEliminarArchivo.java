package com.ceiba.archivo.servicio;

import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;

public class ServicioEliminarArchivo {

    private final RepositorioArchivo repositorioArchivo;

    public ServicioEliminarArchivo(RepositorioArchivo repositorioArchivo) {
        this.repositorioArchivo = repositorioArchivo;
    }

    public void ejecutar(Long id) {
        this.repositorioArchivo.eliminar(id);
    }
}
