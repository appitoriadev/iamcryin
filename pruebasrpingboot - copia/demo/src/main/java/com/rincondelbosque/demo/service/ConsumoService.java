package com.rincondelbosque.demo.service;

import com.rincondelbosque.demo.dto.response.ConsumoResponse;
import java.util.List;

public interface ConsumoService {
    List<ConsumoResponse> listarTodos();
    ConsumoResponse obtenerPorId(Integer idConsumo);
    ConsumoResponse crearConsumo(ConsumoResponse consumo);
    ConsumoResponse actualizarConsumo(Integer idConsumo, ConsumoResponse consumo);
}
