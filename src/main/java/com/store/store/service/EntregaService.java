package com.store.store.service;

import com.store.store.model.Pedido;

public interface EntregaService {
    void asignarEntrega(Integer id, Integer empleado, String ruta);

    void confirmarEntrega(Pedido pedido);
}
