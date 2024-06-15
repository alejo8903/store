package com.store.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.store.store.model.Cliente;
import com.store.store.service.impl.ClienteServiceImpl;

@Controller
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/buscar")
    public List<Cliente> buscarProductos(@RequestParam String documento) {
        return clienteService.buscarPorDocumento(documento);
    }

}
