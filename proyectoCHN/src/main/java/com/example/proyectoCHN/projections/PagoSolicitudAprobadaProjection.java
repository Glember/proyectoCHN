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
public interface PagoSolicitudAprobadaProjection {
    
    int getIdPago();
    int getIdPrestamoAprobado();
    Date getFechaPago();
    BigDecimal getMontoPago();
    
}
