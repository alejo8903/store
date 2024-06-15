package com.store.store.controller;

import com.store.store.dto.PedidoDTO;
import com.store.store.model.*;
import com.store.store.service.*;
import com.store.store.service.impl.PedidoServiceImpl;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Setter
@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private String mensaje;

    @Autowired
    private PedidoServiceImpl pedidoService;

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

    // jose
    @GetMapping("/add")
    public String addPedido(Model model) {
        model.addAttribute("contentTemplate", "fragments/form-add-pedido");
        return "index";
    }

    // jose

    @PostMapping("/registrar")
    public String registrarPedido(@RequestBody PedidoDTO pedidoDTO, RedirectAttributes redirectAttributes) {
        try {
            pedidoService.registrarPedido(pedidoDTO);
            redirectAttributes.addFlashAttribute("mensaje", "Pedido registrado exitosamente");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el pedido: " + e.getMessage());
        }
        return "redirect:/pedidos/add"; // Redirige a la URL de la vista
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Error inesperado al procesar la solicitud: " + e.getMessage());
        return "redirect:/pedidos/add";
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