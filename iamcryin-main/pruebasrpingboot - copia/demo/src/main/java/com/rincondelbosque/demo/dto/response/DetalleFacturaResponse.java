package com.rincondelbosque.demo.dto.response;

import com.rincondelbosque.demo.model.DetalleFactura;

public record DetalleFacturaResponse(
    Integer idDetalle,
    ConsumoResponse consumo,
    Integer cantidad,
    Double precioUnitario,
    Double subtotalDetalle
) {
    public static DetalleFacturaResponse from(DetalleFactura detalle) {
        return new DetalleFacturaResponse(
            detalle.getIdDetalle(),
            ConsumoResponse.from(detalle.getConsumo()),
            detalle.getCantidad(),
            detalle.getPrecioUnitario(),
            detalle.getSubtotalDetalle()
        );
    }
}
