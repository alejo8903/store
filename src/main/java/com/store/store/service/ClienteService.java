package com.store.store.service;

import java.util.List;

import com.store.store.model.Cliente;

public interface ClienteService {
    List<Cliente> buscarPorDocumento(String documento);

    Cliente saveCliente(Cliente cliente);
}
