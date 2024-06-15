package com.store.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.store.store.model.Producto;
import com.store.store.service.impl.ProductoServiceImpl;

@Controller
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productService;

    @GetMapping("/buscar")
    public List<Producto> buscarProductos(@RequestParam String nombre) {
        return productService.buscarPorNombre(nombre);
    }
}
