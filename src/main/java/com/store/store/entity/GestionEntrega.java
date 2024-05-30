package com.store.store.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "GESTION_ENTREGA")
public class GestionEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ruta;
    @Column(name = "ID_PEDIDO")
    private int idPedido;
    @Column(name = "ID_EMPLEADO")
    private int idEmpleado;
}
