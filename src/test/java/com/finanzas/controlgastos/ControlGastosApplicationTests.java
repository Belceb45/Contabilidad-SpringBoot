package com.finanzas.controlgastos;

import com.finanzas.controlgastos.model.Movimiento;
import com.finanzas.controlgastos.repository.MovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test") // Usar un perfil de prueba si es necesario para base de datos
public class ControlGastosApplicationTests {

	@Autowired
	private MovimientoRepository movimientoRepository;

	private Movimiento movimiento;

	@BeforeEach
	public void setUp() {
		movimiento = new Movimiento();
		movimiento.setCuenta("inventario");
		movimiento.setCargo(500);
		movimiento.setAbono(0);

	}

	@Test
	public void testGuardarYObtenerMovimiento() {
		// Guardar el movimiento en la base de datos
		Movimiento guardado = movimientoRepository.save(movimiento);

		// Verificar que el movimiento se guarda correctamente
		Optional<Movimiento> encontrado = movimientoRepository.findById(guardado.getId());
		assertTrue(encontrado.isPresent(), "La operacion debe estar guardada correctamente");
		assertEquals("inventario", encontrado.get().getCuenta());
	}

	@Test
	public void testEliminarMovimiento() {
		// Guardar el movimiento
		Movimiento guardado = movimientoRepository.save(movimiento);

		// Eliminar el movimiento
		movimientoRepository.deleteById(guardado.getId());

		// Verificar que el movimiento fue eliminado
		Optional<Movimiento> eliminado = movimientoRepository.findById(guardado.getId());
		assertFalse(eliminado.isPresent(), "El registro debe estar eliminado");
	}
}
