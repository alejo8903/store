package com.store.store.controller;

import com.store.store.model.Empleado;
import com.store.store.model.Pedido;
import com.store.store.model.PedidoProducto;
import com.store.store.service.EmpleadoService;
import com.store.store.service.EntregaService;
import com.store.store.service.PedidoProductoService;
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

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    EntregaService entregaService;
    @Autowired
    private PedidoProductoService pedidoProductoService;


    @GetMapping("/")
    public String getAllPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("contentTemplate", "fragments/programar-pedidos");
        return "index";
    }

    @GetMapping("/asignar-despacho/{id}")
    public String verPedido(@PathVariable("id") Integer id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("pedido", pedido);
        model.addAttribute("empleados", empleados);
        model.addAttribute("contentTemplate", "fragments/programar-ver-pedido");
        return "index";
    }



    @GetMapping("/{id}")
    public String getPedidoById(@PathVariable("id") Integer id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        List<PedidoProducto> pedidosProductos = pedidoProductoService.getPedidoProductoByPedido(pedido);
        model.addAttribute("pedido", pedido);
        model.addAttribute("pedidosProductos", pedidosProductos);
        model.addAttribute("contentTemplate", "fragments/detalles-pedido");
        return "index";
    }

    @PostMapping("/save")
    public String saveAsignarDespacho(@RequestParam("pedidoId") Integer pedidoId,
                                      @RequestParam("empleadoId") Integer empleadoId,
                                      @RequestParam("ruta") String ruta) {
        entregaService.asignarEntrega(pedidoId, empleadoId, ruta);
        return "redirect:/pedidos/";
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable("id") Integer id) {
        pedidoService.deletePedido(id);
        return "redirect:/pedidos/";
    }

    @PostMapping("/save-entrega")
    public String saveEntrega(@RequestParam("id") Integer pedidoId) {
        Pedido pedido = pedidoService.getPedidoById(pedidoId);
        entregaService.confirmarEntrega(pedido);
        return "redirect:/pedidos/";
    }
}