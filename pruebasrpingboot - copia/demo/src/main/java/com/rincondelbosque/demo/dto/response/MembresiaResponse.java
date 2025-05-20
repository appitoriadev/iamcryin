package com.rincondelbosque.demo.dto.response;

import com.rincondelbosque.demo.model.Membresia;

public record MembresiaResponse(
    Integer idMembresia,
    String codigoMembresia,
    String nombreMembresia,
    String estado,
    Double fondoBase,
    Double fondoActual,
    Double limiteConsumo
) {
    public static MembresiaResponse from(Membresia membresia) {
        return new MembresiaResponse(
            membresia.getIdMembresia(),
            membresia.getCodigoMembresia(),
            membresia.getNombreMembresia(),
            membresia.getEstado(),
            membresia.getFondoBase(),
            membresia.getFondoActual(),
            membresia.getLimiteConsumo()
        );
    }
}
