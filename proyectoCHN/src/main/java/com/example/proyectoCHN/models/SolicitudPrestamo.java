/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author ping_
 */
@Data
@Entity
@Table(name = "solicitud_prestamos", schema = "examenchn")
public class SolicitudPrestamo {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_solicitud_prestamo")
    private int idSolicitudPrestamo;
    
    @Column(name = "id_cliente")
    private int idCliente;
    
    @Column(name = "id_plazo_deseado")
    private int idPlazoDeseado;
    
    @Column(name = "monto_solicitado")
    private BigDecimal montoSolicitado;
    
    @Column(name = "estado_prestamo")
    private int estadoPrestamo;
}
