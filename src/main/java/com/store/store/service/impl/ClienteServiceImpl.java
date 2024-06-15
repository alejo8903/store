package com.store.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.model.Cliente;
import com.store.store.repository.ClienteRepository;
import com.store.store.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> buscarPorDocumento(String documento) {
        return clienteRepository.findByDocumentoContaining(documento);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {

        System.out.println(cliente);

        if (cliente.getId() == null) {
            clienteRepository.save(cliente);
        }
        return clienteRepository.getClienteByDocumento(cliente.getDocumento());
    }

}
