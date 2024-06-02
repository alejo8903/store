package com.store.store.service;

import com.store.store.model.Pedido;
import com.store.store.model.PedidoProducto;

import java.util.List;

public interface PedidoProductoService {
    public List<PedidoProducto> getPedidoProductoByPedido(Pedido pedido);
}
