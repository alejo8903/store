package com.store.store.service;

import com.store.store.dto.PedidoDTO;
import com.store.store.model.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getAllPedidos();

    Pedido getPedidoById(Integer id);

    // List<Producto> productos
    Pedido registrarPedido(PedidoDTO pedidoDTO);

    void deletePedido(Integer id);

}