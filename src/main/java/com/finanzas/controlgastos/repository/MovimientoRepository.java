package com.finanzas.controlgastos.repository;

import com.finanzas.controlgastos.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>
{

}