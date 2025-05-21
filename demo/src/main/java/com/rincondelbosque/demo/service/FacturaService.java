package com.rincondelbosque.demo.service;

import com.rincondelbosque.demo.dto.response.DetalleFacturaResponse;
import com.rincondelbosque.demo.dto.response.FacturaResponse;

import java.util.List;

public interface FacturaService {
    List<FacturaResponse> listarTodas();
    FacturaResponse obtenerPorId(Integer idFactura);
    FacturaResponse crearFactura(FacturaResponse factura);
    FacturaResponse actualizarFactura(Integer idFactura, FacturaResponse factura);
    List<DetalleFacturaResponse> listadetalles();
}
