package com.rincondelbosque.controller;

import com.rincondelbosque.dto.response.PersonaResponse;
import com.rincondelbosque.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaResponse> listarPersonas() {
        return personaService.listarTodas();
    }

    @GetMapping("/{id}")
    public PersonaResponse obtenerPersona(@PathVariable Integer id) {
        return personaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonaResponse crearPersona(@RequestBody PersonaResponse persona) {
        return personaService.crearPersona(persona);
    }

    @PutMapping("/{id}")
    public PersonaResponse actualizarPersona(@PathVariable Integer id, @RequestBody PersonaResponse persona) {
        return personaService.actualizarPersona(id, persona);
    }
}
