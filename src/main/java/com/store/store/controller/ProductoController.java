package com.store.store.controller;

import com.store.store.model.Producto;
import com.store.store.service.ProductoService;
import com.store.store.service.TipoFlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TipoFlorService tipoFlorService;

    @GetMapping("/inventario")
    public String viewInventarioPage(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());
        model.addAttribute("producto", new Producto());
        model.addAttribute("tiposFlor", tipoFlorService.getAllTipoFlor());
        model.addAttribute("contentTemplate", "fragments/inventario");
        return "index";
    }

    @PostMapping("/inventario")
    public String saveProducto(@ModelAttribute("producto") Producto producto) {
        producto.setDisponible(producto.getCantidadDisponible() > 0);
        productoService.saveProducto(producto);
        return "redirect:/inventario";
    }

    @GetMapping("/inventario/eliminar/{id}")
    public String deleteProducto(@PathVariable("id") int id) {
        productoService.deleteProductoById(id);
        return "redirect:/inventario";
    }
}
