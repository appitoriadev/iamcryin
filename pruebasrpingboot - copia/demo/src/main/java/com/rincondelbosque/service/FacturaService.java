package com.rincondelbosque.service;

import com.rincondelbosque.dto.response.FacturaResponse;
import java.util.List;

public interface FacturaService {
    List<FacturaResponse> listarTodas();
    FacturaResponse obtenerPorId(Integer idFactura);
    FacturaResponse crearFactura(FacturaResponse factura);
    FacturaResponse actualizarFactura(Integer idFactura, FacturaResponse factura);
}
