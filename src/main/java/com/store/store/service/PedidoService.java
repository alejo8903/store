package com.store.store.service;

import com.store.store.model.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getAllPedidos();

    Pedido getPedidoById(Integer id);

    Pedido savePedido(Pedido pedido);

    void deletePedido(Integer id);
}