package com.rincondelbosque.controller;

import com.rincondelbosque.dto.response.ConsumoResponse;
import com.rincondelbosque.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumos")
public class ConsumoController {
    @Autowired
    private ConsumoService consumoService;

    @GetMapping
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
