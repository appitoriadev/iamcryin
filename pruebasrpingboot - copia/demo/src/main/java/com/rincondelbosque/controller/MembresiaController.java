package com.rincondelbosque.controller;

import com.rincondelbosque.dto.response.MembresiaResponse;
import com.rincondelbosque.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {
    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public List<MembresiaResponse> listarMembresias() {
        return membresiaService.listarTodas();
    }

    @GetMapping("/{id}")
    public MembresiaResponse obtenerMembresia(@PathVariable Integer id) {
        return membresiaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MembresiaResponse crearMembresia(@RequestBody MembresiaResponse membresia) {
        return membresiaService.crearMembresia(membresia);
    }

    @PutMapping("/{id}")
    public MembresiaResponse actualizarMembresia(@PathVariable Integer id, @RequestBody MembresiaResponse membresia) {
        return membresiaService.actualizarMembresia(id, membresia);
    }
}
