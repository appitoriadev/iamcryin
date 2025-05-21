package com.rincondelbosque.demo.service.impl;

import com.rincondelbosque.demo.dto.response.ConsumoResponse;
import com.rincondelbosque.demo.dto.response.DetalleFacturaResponse;
import com.rincondelbosque.demo.dto.response.FacturaResponse;
import com.rincondelbosque.demo.dto.response.PersonaResponse;
import com.rincondelbosque.demo.model.DetalleFactura;
import com.rincondelbosque.demo.model.Factura;
import com.rincondelbosque.demo.repository.DetalleFacturaRepository;
import com.rincondelbosque.demo.repository.FacturaRepository;
import com.rincondelbosque.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<FacturaResponse> listarTodas() {
        // Get all facturas
        List<Factura> facturas = facturaRepository.findAll();
        
        // Get all details for these facturas
        List<DetalleFactura> detalles = detalleFacturaRepository.findAll();
        
        // Create a map of factura ID to its details
        Map<Integer, List<DetalleFactura>> detallesPorFactura = detalles.stream()
            .collect(Collectors.groupingBy(detalle -> detalle.getFactura().getIdFactura()));
        
        // Map facturas to FacturaResponse with their details
        return facturas.stream()
            .map(factura -> {
                List<DetalleFacturaResponse> detallesResponse = detallesPorFactura
                    .getOrDefault(factura.getIdFactura(), Collections.emptyList())
                    .stream()
                    .map(detalle -> new DetalleFacturaResponse(
                        detalle.getIdDetalle(),
                        ConsumoResponse.from(detalle.getConsumo()),
                        detalle.getCantidad(),
                        detalle.getPrecioUnitario(),
                        detalle.getSubtotalDetalle()
                    ))
                    .collect(Collectors.toList());
                
                return new FacturaResponse(
                    factura.getIdFactura(),
                    factura.getNumeroFactura(),
                    PersonaResponse.from(factura.getSocio()),
                    factura.getFechaFactura() != null ? factura.getFechaFactura().toString() : null,
                    factura.getTotalSinImpuestos(),
                    factura.getImpuesto(),
                    factura.getTotalConImpuestos(),
                    factura.getEstado(),
                    detallesResponse
                );
            })
            .collect(Collectors.toList());
    }

    @Override
    public List<DetalleFacturaResponse> listadetalles(){
        return detalleFacturaRepository.findAll().stream()
                .map(DetalleFacturaResponse::from)
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
