package com.rincondelbosque.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class FacturaRequest {

    @NotNull(message = "El ID del socio es obligatorio")
    private Integer idSocio;

    @NotNull(message = "El método de pago es obligatorio")
    private String metodoPago;

    @NotEmpty(message = "Debe incluir al menos un detalle")
    @Valid
    private List<DetalleFacturaRequest> detalles;

    // Getters y Setters
    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetalleFacturaRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaRequest> detalles) {
        this.detalles = detalles;
    }
}