package com.store.store.controller;

import com.store.store.model.Producto;
import com.store.store.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/inventario")
    public String inventario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", productoService.getAllProductos());
        return "fragments/inventario :: content";
    }

    @PostMapping("/inventario")
    public String saveProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/inventario";
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
