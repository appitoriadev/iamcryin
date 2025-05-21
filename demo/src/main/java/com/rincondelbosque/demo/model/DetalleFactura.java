package com.rincondelbosque.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_consumo", nullable = false)
    private Consumo consumo;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "subtotal_detalle", nullable = false)
    private Double subtotalDetalle;

    // Getters y Setters
    public Integer getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Integer idDetalle) { this.idDetalle = idDetalle; }
    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }
    public Consumo getConsumo() { return consumo; }
    public void setConsumo(Consumo consumo) { this.consumo = consumo; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getSubtotalDetalle() { return subtotalDetalle; }
    public void setSubtotalDetalle(Double subtotalDetalle) { this.subtotalDetalle = subtotalDetalle; }
}
