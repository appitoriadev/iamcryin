package com.rincondelbosque.service;

import com.rincondelbosque.dto.response.MembresiaResponse;
import java.util.List;

public interface MembresiaService {
    List<MembresiaResponse> listarTodas();
    MembresiaResponse obtenerPorId(Integer idMembresia);
    MembresiaResponse crearMembresia(MembresiaResponse membresia);
    MembresiaResponse actualizarMembresia(Integer idMembresia, MembresiaResponse membresia);
}
