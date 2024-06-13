package com.store.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contentTemplate", "fragments/home");
        return "index";
    }

    @GetMapping("/generar-pedido")
    public String generarPedido(Model model) {
        model.addAttribute("contentTemplate", "fragments/generar-pedido");
        return "index";
    }
}
