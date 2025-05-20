package com.rincondelbosque.dto.request;

import jakarta.validation.constraints.*;

public class MembresiaRequest {

    @NotBlank(message = "El código de membresía es obligatorio")
    @Size(max = 20, message = "El código no puede exceder los 20 caracteres")
    private String codigoMembresia;

    @NotBlank(message = "El nombre de la membresía es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombreMembresia;

    @Pattern(regexp = "activo|inactivo", message = "El estado debe ser 'activo' o 'inactivo'")
    private String estado = "activo"; // Valor por defecto

    @NotNull(message = "El fondo base es obligatorio")
    @PositiveOrZero(message = "El fondo base no puede ser negativo")
    private Double fondoBase;

    @PositiveOrZero(message = "El fondo actual no puede ser negativo")
    private Double fondoActual = 0.0; // Valor por defecto

    @NotNull(message = "El límite de consumo es obligatorio")
    @Positive(message = "El límite de consumo debe ser mayor a cero")
    private Double limiteConsumo;

    // Getters y Setters
    public String getCodigoMembresia() { return codigoMembresia; }
    public void setCodigoMembresia(String codigoMembresia) { this.codigoMembresia = codigoMembresia; }

    public String getNombreMembresia() { return nombreMembresia; }
    public void setNombreMembresia(String nombreMembresia) { this.nombreMembresia = nombreMembresia; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getFondoBase() { return fondoBase; }
    public void setFondoBase(Double fondoBase) { this.fondoBase = fondoBase; }

    public Double getFondoActual() { return fondoActual; }
    public void setFondoActual(Double fondoActual) { this.fondoActual = fondoActual; }

    public Double getLimiteConsumo() { return limiteConsumo; }
    public void setLimiteConsumo(Double limiteConsumo) { this.limiteConsumo = limiteConsumo; }
}   