package com.store.store.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String color;
    private String variedad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_flor", referencedColumnName = "id")
    private TipoFlor tipoFlor;

    @Column(name = "PRECIO_VENTA")
    private double precioVenta;

    @Column(name = "DESCRIPCION_CUIDADO")
    private String descripcionCuidado;

    @Column(name = "CANTIDAD_DISPONIBLE")
    private int cantidadDisponible;

    @Column(name = "PRECIO_COMPRA")
    private double precioCompra;
}
