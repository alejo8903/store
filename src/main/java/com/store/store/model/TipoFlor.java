package com.store.store.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_flor")
public class TipoFlor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "tipoFlor")
    private List<Producto> productos;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
