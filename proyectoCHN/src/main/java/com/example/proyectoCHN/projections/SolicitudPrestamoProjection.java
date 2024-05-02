/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoCHN.projections;

import java.math.BigDecimal;

/**
 *
 * @author ping_
 */
public interface SolicitudPrestamoProjection {
    
    int getIdSolicitudPrestamo();
    int getIdCliente();
    String getNombre();
    BigDecimal getMontoSolicitado();
    int getIdPlazodeseado();
    int getEstado();

}
