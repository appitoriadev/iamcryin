package com.rincondelbosque.demo.dto.response;

import com.rincondelbosque.demo.model.Consumo;

public record ConsumoResponse(
    Integer idConsumo,
    String codigoProducto,
    String nombreProducto,
    String descripcion,
    Double precio,
    String estado
) {
    public static ConsumoResponse from(Consumo consumo) {
        return new ConsumoResponse(
            consumo.getIdConsumo(),
            consumo.getCodigoProducto(),
            consumo.getNombreProducto(),
            consumo.getDescripcion(),
            consumo.getPrecio(),
            consumo.getEstado()
        );
    }
}
