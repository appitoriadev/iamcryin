package com.rincondelbosque.demo.service.impl;

import com.rincondelbosque.demo.dto.response.PersonaResponse;
import com.rincondelbosque.demo.model.Persona;
import com.rincondelbosque.demo.repository.PersonaRepository;
import com.rincondelbosque.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaResponse> listarTodas() {
        return personaRepository.findAll().stream()
                .map(PersonaResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaResponse obtenerPorId(Integer idPersona) {
        return personaRepository.findById(idPersona)
                .map(PersonaResponse::from)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public PersonaResponse crearPersona(PersonaResponse persona) {
        Persona entity = new Persona();
        // Asignar campos desde el DTO
        // ...
        return PersonaResponse.from(personaRepository.save(entity));
    }

    @Override
    public PersonaResponse actualizarPersona(Integer idPersona, PersonaResponse persona) {
        Persona entity = personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        // Actualizar campos desde el DTO
        // ...
        return PersonaResponse.from(personaRepository.save(entity));
    }
}
