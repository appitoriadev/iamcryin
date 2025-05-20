package com.rincondelbosque.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "numero_factura", length = 50, unique = true, nullable = false)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "id_socio", nullable = false)
    private Persona socio;

    @Column(name = "fecha_factura")
    private LocalDateTime fechaFactura;

    @Column(name = "total_sin_impuestos")
    private Double totalSinImpuestos;

    @Column(name = "impuesto")
    private Double impuesto;

    @Column(name = "total_con_impuestos")
    private Double totalConImpuestos;

    @Column(length = 20, nullable = false)
    private String estado;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<>();

    // Getters y Setters
    public Integer getIdFactura() { return idFactura; }
    public void setIdFactura(Integer idFactura) { this.idFactura = idFactura; }
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public Persona getSocio() { return socio; }
    public void setSocio(Persona socio) { this.socio = socio; }
    public LocalDateTime getFechaFactura() { return fechaFactura; }
    public void setFechaFactura(LocalDateTime fechaFactura) { this.fechaFactura = fechaFactura; }
    public Double getTotalSinImpuestos() { return totalSinImpuestos; }
    public void setTotalSinImpuestos(Double totalSinImpuestos) { this.totalSinImpuestos = totalSinImpuestos; }
    public Double getImpuesto() { return impuesto; }
    public void setImpuesto(Double impuesto) { this.impuesto = impuesto; }
    public Double getTotalConImpuestos() { return totalConImpuestos; }
    public void setTotalConImpuestos(Double totalConImpuestos) { this.totalConImpuestos = totalConImpuestos; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<DetalleFactura> getDetalles() { return detalles; }
}