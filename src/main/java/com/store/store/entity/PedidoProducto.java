package com.store.store.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PEDIDO_PRODUCTO")
public class PedidoProducto {
    @Id
    private int id;
    @Column(name = "ID_PEDIDO")
    private int idPedido;
    @Column(name = "ID_PRODUCTO")
    private int idProducto;
}