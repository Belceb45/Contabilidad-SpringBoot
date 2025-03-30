package com.finanzas.controlgastos.service;

import com.finanzas.controlgastos.model.Movimiento;
import com.finanzas.controlgastos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    // Guardar un nuevo movimiento
    public Movimiento guardarMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    // Obtener todos los movimientos
    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoRepository.findAll();
    }

    // Obtener un movimiento por su ID
    public Optional<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id);
    }

    // Eliminar un movimiento por su ID
    public void eliminarMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}
