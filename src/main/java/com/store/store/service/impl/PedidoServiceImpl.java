package com.store.store.service.impl;

import com.store.store.dto.PedidoDTO;
import com.store.store.dto.ProductoDTO;
import com.store.store.model.*;
import com.store.store.repository.PedidoRepository;
import com.store.store.repository.ProductoRepository;
import com.store.store.service.PedidoService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // creado por jose
    @Override
    @Transactional
    public Pedido registrarPedido(PedidoDTO pedidoDTO) {

        Cliente cliente = clienteService.saveCliente(pedidoDTO.getCliente());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setOcasion(pedidoDTO.getOcasion());
        pedido.setFechaEntrega(pedidoDTO.getFechaEntrega());
        pedido.setPrecio(pedidoDTO.getPrecio());
        pedido.setEstado("PENDIENTE");

        for (ProductoDTO pp : pedidoDTO.getProductos()) {
            Producto producto = productoRepository.findById(pp.getId()).orElse(null);
            if (producto.getCantidadDisponible() >= pp.getCantidad()) {
                // Actualizar la cantidad disponible del producto
                producto.setCantidadDisponible(producto.getCantidadDisponible() - pp.getCantidad());
                productoRepository.save(producto);

                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setPedido(pedido);
                pedidoProducto.setProducto(producto);
                pedidoProducto.setCantidad(pp.getCantidad());
                pedidoProducto.setId(new PedidoProductoId(pedido.getId(), producto.getId()));

                pedido.getProductos().add(pedidoProducto);

            } else {
                // Manejar el caso donde no hay suficiente cantidad disponible
                throw new RuntimeException(
                        "No hay suficiente cantidad disponible para el producto: " + producto.getNombre());
            }

        }
        return pedidoRepository.save(pedido);

    }

    @Override
    public void deletePedido(Integer id) {
        pedidoRepository.deleteById(id);
    }

}