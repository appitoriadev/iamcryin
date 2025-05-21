package com.rincondelbosque.demo.service;

import com.rincondelbosque.demo.dto.response.PersonaResponse;
import java.util.List;

public interface PersonaService {
    List<PersonaResponse> listarTodas();
    PersonaResponse obtenerPorId(Integer idPersona);
    PersonaResponse crearPersona(PersonaResponse persona);
    PersonaResponse actualizarPersona(Integer idPersona, PersonaResponse persona);
}
