package com.store.store.controller;

import com.store.store.model.Pedido;
import com.store.store.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping("/")
    public String getAllPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        model.addAttribute("pedidos", pedidos);
        return "fragments/programar-pedidos :: content";
    }

    @GetMapping("/{id}")
    public String getPedidoById(@PathVariable("id") Integer id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        model.addAttribute("pedido", pedido);
        return "pedidos/detail";
    }

    @PostMapping("/")
    public String savePedido(@ModelAttribute Pedido pedido) {
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos/";
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable("id") Integer id) {
        pedidoService.deletePedido(id);
        return "redirect:/pedidos/";
    }
}