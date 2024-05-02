/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoCHN.projections;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ping_
 */
public interface PagoPrestamoProjection {
    
    int getIdPrestamoAprobado();

    int getIdCliente();

    String getNombre();

    int getEstadoPrestamoAprobado();

    BigDecimal getMontoSolicitado();

    Date getFechaAprobacion();
    BigDecimal getMontoPago();
    BigDecimal getSaldo();
    
}
