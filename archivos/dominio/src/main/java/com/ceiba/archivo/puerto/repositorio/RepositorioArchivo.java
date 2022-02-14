package com.ceiba.archivo.puerto.repositorio;

import com.ceiba.archivo.modelo.entidad.Archivo;

public interface RepositorioArchivo {

    /**
     * Permite crear un archivo
     * @param archivo
     * @return el id generado
     */
    Long crear(Archivo archivo);

    /**
     * Permite actualizar un archivo
     * @param archivo
     */
    void actualizar(Archivo archivo);

    /**
     * Permite eliminar un archivo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un archivo por id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
