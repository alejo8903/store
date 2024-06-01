package com.store.store.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String color;
    private String variedad;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private boolean disponible;

    @Column(name = "cantidad_disponible")
    private BigDecimal cantDisponible;

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @ManyToOne
    @JoinColumn(name = "id_tipo_flor", insertable = false, updatable = false)
    private TipoFlor tipoFlor;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(BigDecimal cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

}
