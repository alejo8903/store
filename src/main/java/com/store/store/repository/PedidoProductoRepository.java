package com.store.store.repository;

import com.store.store.model.Pedido;
import com.store.store.model.PedidoProducto;
import com.store.store.model.PedidoProductoId;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, PedidoProductoId> {
    List<PedidoProducto> findByPedido(Pedido pedido);
}
