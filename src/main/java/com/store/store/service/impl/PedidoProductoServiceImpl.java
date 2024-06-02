package com.store.store.service.impl;

import com.store.store.model.Pedido;
import com.store.store.model.PedidoProducto;
import com.store.store.repository.PedidoProductoRepository;
import com.store.store.service.PedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoServiceImpl implements PedidoProductoService {

    @Autowired
    private PedidoProductoRepository pedidoProductoRepository;

    @Override
    public List<PedidoProducto> getPedidoProductoByPedido(Pedido pedido) {
        return pedidoProductoRepository.findByPedido(pedido);
    }
}
