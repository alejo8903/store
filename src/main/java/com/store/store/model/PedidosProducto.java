package com.store.store.model;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "pedidos_productos")
public class PedidosProducto {

    @EmbeddedId
    private PedidosProductoPK id;

    private Integer cantidad;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Pedido Pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public PedidosProductoPK getId() {
        return id;
    }

    public void setId(PedidosProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
