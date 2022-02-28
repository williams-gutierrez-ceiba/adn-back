package com.ceiba.archivo.controlador;

import com.ceiba.archivo.consulta.ManejadorListarArchivos;
import com.ceiba.archivo.consulta.ManejadorListarArchivosPorVivienda;
import com.ceiba.archivo.modelo.dto.DtoArchivo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/archivos")
@Api(tags={"Controlador consulta archivos"})
public class ConsultaControladorArchivo {

    private final ManejadorListarArchivos manejadorListarArchivos;
    private final ManejadorListarArchivosPorVivienda manejadorListarArchivosPorVivienda;

    public ConsultaControladorArchivo(ManejadorListarArchivos manejadorListarArchivos, ManejadorListarArchivosPorVivienda manejadorListarArchivosPorVivienda) {
        this.manejadorListarArchivos = manejadorListarArchivos;
        this.manejadorListarArchivosPorVivienda = manejadorListarArchivosPorVivienda;
    }

    @GetMapping
    @ApiOperation("Listar Archivos")
    public List<DtoArchivo> listar() {
        return this.manejadorListarArchivos.ejecutar();
    }

    @GetMapping("/{viviendaId}")
    @ApiOperation("Listar Archivos")
    public List<DtoArchivo> listarPorViviendaId(@PathVariable Long viviendaId) {
        return this.manejadorListarArchivosPorVivienda.ejecutar(viviendaId);
    }
}
