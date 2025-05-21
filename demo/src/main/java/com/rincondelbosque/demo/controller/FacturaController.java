package com.rincondelbosque.demo.controller;

import com.rincondelbosque.demo.dto.response.FacturaResponse;
import com.rincondelbosque.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<FacturaResponse> listarFacturas() {
        return facturaService.listarTodas();
    }

    @GetMapping("/{id}")
    public FacturaResponse obtenerFactura(@PathVariable Integer id) {
        return facturaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FacturaResponse crearFactura(@RequestBody FacturaResponse factura) {
        return facturaService.crearFactura(factura);
    }

    @PutMapping("/{id}")
    public FacturaResponse actualizarFactura(@PathVariable Integer id, @RequestBody FacturaResponse factura) {
        return facturaService.actualizarFactura(id, factura);
    }
}
