package com.finanzas.controlgastos.controller;

import com.finanzas.controlgastos.model.Movimiento;
import com.finanzas.controlgastos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoApiController {

    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoApiController(MovimientoService movimientoService)
    {
        this.movimientoService = movimientoService;
    }

    // Exportar todos los movimientos como JSON
    @GetMapping
    public List<Movimiento> obtenerTodosLosMovimientos()
    {
        return movimientoService.obtenerTodosLosMovimientos();
    }

    // Obtener un movimiento por ID
    @GetMapping("/{id}")
    public Optional<Movimiento> obtenerMovimientoPorId(@PathVariable Long id)
    {
        return movimientoService.obtenerMovimientoPorId(id);
    }

    // Guardar un nuevo movimiento (API)
    @PostMapping("/nuevo")
    public Movimiento guardarMovimiento(@RequestBody Movimiento movimiento)
    {
        return movimientoService.guardarMovimiento(movimiento);
    }

    // Eliminar un movimiento
    @DeleteMapping("/eliminar/{id}")
    public void eliminarMovimiento(@PathVariable Long id)
    {
        movimientoService.eliminarMovimiento(id);
    }

    // Actualizar un movimiento
    @PutMapping("/actualizar")
    public Movimiento actualizarMovimiento(@RequestBody Movimiento movimiento)
    {
        return movimientoService.guardarMovimiento(movimiento);
    }
}
