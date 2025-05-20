package com.rincondelbosque.demo.dto.response;

import com.rincondelbosque.demo.model.Persona;

public record PersonaResponse(
    Integer idPersona,
    String nombre,
    String apellido,
    String documentoIdentidad,
    String email,
    String telefono,
    String direccion,
    String rol,
    String estado,
    MembresiaResponse membresia
) {
    public static PersonaResponse from(Persona persona) {
        return new PersonaResponse(
            persona.getIdPersona(),
            persona.getNombre(),
            persona.getApellido(),
            persona.getDocumentoIdentidad(),
            persona.getEmail(),
            persona.getTelefono(),
            persona.getDireccion(),
            persona.getRol(),
            persona.getEstado(),
            persona.getMembresia() != null ? MembresiaResponse.from(persona.getMembresia()) : null
        );
    }
}
