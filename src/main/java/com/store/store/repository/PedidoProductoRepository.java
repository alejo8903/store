package com.store.store.repository;

import com.store.store.model.Pedido;
import com.store.store.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer>{
    List<PedidoProducto> findByPedido(Pedido pedido);
}
