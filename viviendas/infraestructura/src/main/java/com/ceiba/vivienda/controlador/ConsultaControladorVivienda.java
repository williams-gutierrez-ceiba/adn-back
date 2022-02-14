package com.ceiba.vivienda.controlador;

import com.ceiba.vivienda.consulta.ManejadorConsultarViviendaPorId;
import com.ceiba.vivienda.consulta.ManejadorListarViviendas;
import com.ceiba.vivienda.modelo.dto.DtoVivienda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viviendas")
@Api(tags={"Controlador consulta vivienda"})
public class ConsultaControladorVivienda {

    private final ManejadorListarViviendas manejadorListarViviendas;
    private final ManejadorConsultarViviendaPorId manejadorConsultarViviendaPorId;

    public ConsultaControladorVivienda(ManejadorListarViviendas manejadorListarViviendas,
                                       ManejadorConsultarViviendaPorId manejadorConsultarViviendaPorId) {
        this.manejadorListarViviendas = manejadorListarViviendas;
        this.manejadorConsultarViviendaPorId = manejadorConsultarViviendaPorId;
    }

    @GetMapping
    @ApiOperation("Listar Viviendas")
    public List<DtoVivienda> listar() {
        return this.manejadorListarViviendas.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Consultar vivienda por identificador")
    public DtoVivienda consultarPorId(@PathVariable Long id) {
        return manejadorConsultarViviendaPorId.ejecutar(id);
    }
}
