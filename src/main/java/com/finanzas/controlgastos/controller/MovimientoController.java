package com.finanzas.controlgastos.controller;

import com.finanzas.controlgastos.model.Movimiento;
import com.finanzas.controlgastos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    // Mostrar todos los movimientos (Vista Thymeleaf)
    @GetMapping
    public String mostrarMovimientos(Model model) {
        List<Movimiento> movimientos = movimientoService.obtenerTodosLosMovimientos();
        model.addAttribute("movimientos", movimientos);
        return "movimientos"; // Vista que mostraremos en thymeleaf
    }

    // Mostrar formulario para agregar un nuevo movimiento
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoMovimiento(Model model) {
        model.addAttribute("movimiento", new Movimiento());
        return "formularioMovimiento"; // Vista del formulario
    }

    // Procesar el formulario de nuevo movimiento
    @PostMapping("/nuevo")
    public String guardarMovimiento(@ModelAttribute Movimiento movimiento) {
        movimientoService.guardarMovimiento(movimiento);
        return "redirect:/movimientos"; // Redirigir al listado de movimientos
    }

    // Eliminar un movimiento
    @GetMapping("/eliminar/{id}")
    public String eliminarMovimiento(@PathVariable("id") Long id) {
        movimientoService.eliminarMovimiento(id);
        return "redirect:/movimientos"; // Redirigir al listado después de eliminar
    }

    // Editar movimiento
    @GetMapping("/editar/{id}")
    public String editarMovimiento(@PathVariable Long id, Model model) {
        Movimiento movimiento = movimientoService.obtenerMovimientoPorId(id).orElse(null);
        model.addAttribute("movimiento", movimiento);
        return "editar";
    }

    // Procesar la actualización
    @PostMapping("/actualizar")
    public String actualizarMovimiento(@ModelAttribute Movimiento movimiento) {
        movimientoService.guardarMovimiento(movimiento);
        return "redirect:/movimientos";
    }
}

