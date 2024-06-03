package com.store.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String color;

    private String variedad;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(nullable = false)
    private Integer cantidadDisponible;

    @Column(nullable = false)
    private Double precioVenta;

    @Column(nullable = false)
    private Double precioCompra;

    @ManyToOne
    @JoinColumn(name = "id_tipo_flor", nullable = false)
    private TipoFlor tipoFlor;

}
