package com.store.store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/inventario")
    public String inventario() {
        return "fragments/inventario :: content";
    }

    @GetMapping("/generar-pedido")
    public String generarPedido() {
        return "fragments/generar-pedido :: content";
    }

    @GetMapping("/programar-pedidos")
    public String programarPedidos() {
        return "fragments/programar-pedidos :: content";
    }
}
