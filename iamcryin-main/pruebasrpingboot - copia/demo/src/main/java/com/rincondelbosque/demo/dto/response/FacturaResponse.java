package com.rincondelbosque.demo.dto.response;

import com.rincondelbosque.demo.model.Factura;
import java.util.List;
import java.util.stream.Collectors;

public record FacturaResponse(
    Integer idFactura,
    String numeroFactura,
    PersonaResponse socio,
    String fechaFactura,
    Double totalSinImpuestos,
    Double impuesto,
    Double totalConImpuestos,
    String estado,
    List<DetalleFacturaResponse> detalles
) {
    public static FacturaResponse from(Factura factura) {
        return new FacturaResponse(
            factura.getIdFactura(),
            factura.getNumeroFactura(),
            PersonaResponse.from(factura.getSocio()),
            factura.getFechaFactura() != null ? factura.getFechaFactura().toString() : null,
            factura.getTotalSinImpuestos(),
            factura.getImpuesto(),
            factura.getTotalConImpuestos(),
            factura.getEstado(),
            factura.getDetalles() != null ? factura.getDetalles().stream().map(DetalleFacturaResponse::from).collect(Collectors.toList()) : null
        );
    }
}
