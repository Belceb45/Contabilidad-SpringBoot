package com.finanzas.controlgastos.model;

import jakarta.persistence.*;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    // Getters y Setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String cuenta;

    @NotNull
    private float cargo;

    @NotNull
    private float abono;


    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCuenta()
    {
        return cuenta;
    }

    public void setCuenta(String cuenta)
    {
        this.cuenta = cuenta;
    }

    public float getCargo()
    {
        return cargo;
    }

    public void setCargo(float cargo)
    {
        this.cargo = cargo;
    }

    public float getAbono()
    {
        return abono;
    }
    public void setAbono(float abono)
    {
        this.abono = abono;
    }


}
