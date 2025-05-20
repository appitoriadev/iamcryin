package com.rincondelbosque.demo.service.impl;

import com.rincondelbosque.demo.dto.response.FacturaResponse;
import com.rincondelbosque.demo.model.Factura;
import com.rincondelbosque.demo.repository.FacturaRepository;
import com.rincondelbosque.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<FacturaResponse> listarTodas() {
        return facturaRepository.findAll().stream()
                .map(FacturaResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public FacturaResponse obtenerPorId(Integer idFactura) {
        return facturaRepository.findById(idFactura)
                .map(FacturaResponse::from)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public FacturaResponse crearFactura(FacturaResponse factura) {
        Factura entity = new Factura();
        // Asignar campos desde el DTO
        // ...
        return FacturaResponse.from(facturaRepository.save(entity));
    }

    @Override
    public FacturaResponse actualizarFactura(Integer idFactura, FacturaResponse factura) {
        Factura entity = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        // Actualizar campos desde el DTO
        // ...
        return FacturaResponse.from(facturaRepository.save(entity));
    }
}
