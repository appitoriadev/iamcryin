package com.rincondelbosque.service;

import com.rincondelbosque.dto.response.ConsumoResponse;
import java.util.List;

public interface ConsumoService {
    List<ConsumoResponse> listarTodos();
    ConsumoResponse obtenerPorId(Integer idConsumo);
    ConsumoResponse crearConsumo(ConsumoResponse consumo);
    ConsumoResponse actualizarConsumo(Integer idConsumo, ConsumoResponse consumo);
}
