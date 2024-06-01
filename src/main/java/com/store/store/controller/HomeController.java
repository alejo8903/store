package com.store.store.controller;


<<<<<<< HEAD
import com.store.store.entity.Producto;
=======

import com.store.store.model.Producto;
>>>>>>> 7e366f98e3e5a4b079156422034c0f51a930b7cc
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
<<<<<<< HEAD
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
=======
>>>>>>> 7e366f98e3e5a4b079156422034c0f51a930b7cc
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

}
