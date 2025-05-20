package com.rincondelbosque.demo.service;

import com.rincondelbosque.demo.dto.response.MembresiaResponse;
import java.util.List;

public interface MembresiaService {
    List<MembresiaResponse> listarTodas();
    MembresiaResponse obtenerPorId(Integer idMembresia);
    MembresiaResponse crearMembresia(MembresiaResponse membresia);
    MembresiaResponse actualizarMembresia(Integer idMembresia, MembresiaResponse membresia);
}
