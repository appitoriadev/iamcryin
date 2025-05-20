package com.rincondelbosque.demo.controller;

import com.rincondelbosque.demo.dto.response.ConsumoResponse;
import com.rincondelbosque.demo.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
@RequestMapping("/api/consumos")
public class ConsumoController {
    @Autowired
    private ConsumoService consumoService;

    @GetMapping
    @Operation(summary="Listar todos los consumos", description="Usado para listar todos los consumos")
    public List<ConsumoResponse> listarConsumos() {
        return consumoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ConsumoResponse obtenerConsumo(@PathVariable Integer id) {
        return consumoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumoResponse crearConsumo(@RequestBody ConsumoResponse consumo) {
        return consumoService.crearConsumo(consumo);
    }

    @PutMapping("/{id}")
    public ConsumoResponse actualizarConsumo(@PathVariable Integer id, @RequestBody ConsumoResponse consumo) {
        return consumoService.actualizarConsumo(id, consumo);
    }
}
