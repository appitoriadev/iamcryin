package com.rincondelbosque.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Membresia")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private Integer idMembresia;

    @Column(name = "codigo_membresia", length = 10, unique = true, nullable = false)
    private String codigoMembresia;

    @Column(name = "nombre_membresia", length = 50, nullable = false)
    private String nombreMembresia;

    @Column(name = "fondo_base", precision = 10, scale = 2, nullable = false)
    private Double fondoBase;

    @Column(name = "limite_consumo", precision = 10, scale = 2, nullable = false)
    private Double limiteConsumo;

    @Column(name = "fondo_actual", precision = 10, scale = 2, nullable = false)
    private Double fondoActual;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // Getters y Setters
    public Integer getIdMembresia() { return idMembresia; }
    public void setIdMembresia(Integer idMembresia) { this.idMembresia = idMembresia; }
    public String getCodigoMembresia() { return codigoMembresia; }
    public void setCodigoMembresia(String codigoMembresia) { this.codigoMembresia = codigoMembresia; }
    public String getNombreMembresia() { return nombreMembresia; }
    public void setNombreMembresia(String nombreMembresia) { this.nombreMembresia = nombreMembresia; }
    public Double getFondoBase() { return fondoBase; }
    public void setFondoBase(Double fondoBase) { this.fondoBase = fondoBase; }
    public Double getLimiteConsumo() { return limiteConsumo; }
    public void setLimiteConsumo(Double limiteConsumo) { this.limiteConsumo = limiteConsumo; }
    public Double getFondoActual() { return fondoActual; }
    public void setFondoActual(Double fondoActual) { this.fondoActual = fondoActual; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
}
