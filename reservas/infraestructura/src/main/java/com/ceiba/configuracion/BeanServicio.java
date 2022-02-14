package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCalcularValorTotalReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.reserva.servicio.ServicioValidarDisponibilidadVivienda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda(RepositorioReserva repositorioReserva) {
        return new ServicioValidarDisponibilidadVivienda(repositorioReserva);
    }

    @Bean
    public ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva(RepositorioReserva repositorioReserva) {
        return new ServicioCalcularValorTotalReserva(repositorioReserva);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(
            RepositorioReserva repositorioReserva,
            ServicioValidarDisponibilidadVivienda servicioValidarDisponibilidadVivienda,
            ServicioCalcularValorTotalReserva servicioCalcularValorTotalReserva) {
        return new ServicioCrearReserva(repositorioReserva,
                                        servicioValidarDisponibilidadVivienda,
                                        servicioCalcularValorTotalReserva);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }
	

}
