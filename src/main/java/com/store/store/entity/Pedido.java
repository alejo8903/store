package com.store.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    private String ocasion;
    @Column(name = "FECHA_ENTREGA")
    private Date fechaEntrega;
    private double precio;
    private String estado;
}
