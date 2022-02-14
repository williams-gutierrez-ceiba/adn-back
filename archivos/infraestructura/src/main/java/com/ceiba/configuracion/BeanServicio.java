package com.ceiba.configuracion;

import com.ceiba.archivo.puerto.repositorio.RepositorioArchivo;
import com.ceiba.archivo.servicio.ServicioActualizarArchivo;
import com.ceiba.archivo.servicio.ServicioCrearArchivo;
import com.ceiba.archivo.servicio.ServicioEliminarArchivo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearArchivo servicioCrearArchivo(RepositorioArchivo repositorioArchivo) {
        return new ServicioCrearArchivo(repositorioArchivo);
    }

    @Bean
    public ServicioEliminarArchivo servicioEliminarArchivo(RepositorioArchivo repositorioArchivo) {
        return new ServicioEliminarArchivo(repositorioArchivo);
    }

    @Bean
    public ServicioActualizarArchivo servicioActualizarArchivo(RepositorioArchivo repositorioArchivo) {
        return new ServicioActualizarArchivo(repositorioArchivo);
    }
	

}
