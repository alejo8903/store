package com.store.store.service.impl;

import com.store.store.model.Empleado;
import com.store.store.model.Entrega;
import com.store.store.model.Pedido;
import com.store.store.repository.EmpleadoRepository;
import com.store.store.repository.EntregaRepository;
import com.store.store.repository.PedidoRepository;
import com.store.store.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaServiceImpl implements EntregaService {


    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void asignarEntrega(Integer id, Integer empleado, String ruta) {
        Empleado empleadoA = empleadoRepository.findById(empleado).orElse(null);
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        pedido.setEstado("Programado");
        Entrega entrega = new Entrega();
        entrega.setEmpleado(empleadoA);
        entrega.setPedido(pedido);
        entrega.setRuta(ruta);
        entregaRepository.save(entrega);

    }

    @Override
    public void confirmarEntrega(Pedido pedido) {
        pedido.setEstado("Entregado");
        pedidoRepository.save(pedido);
    }
}
