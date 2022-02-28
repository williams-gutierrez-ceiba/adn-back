package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservasPorUsuario;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservasPorUsuario manejadorListarReservasPorUsuario;

    public ConsultaControladorReserva(ManejadorListarReservasPorUsuario manejadorListarReservasPorUsuario) {
        this.manejadorListarReservasPorUsuario = manejadorListarReservasPorUsuario;
    }

    @GetMapping("/{usuarioId}")
    @ApiOperation("Listar Reservas")
    public List<DtoReserva> listarPorUsuarioId(@PathVariable String usuarioId) {
        return manejadorListarReservasPorUsuario.ejecutar(usuarioId);
    }
}
