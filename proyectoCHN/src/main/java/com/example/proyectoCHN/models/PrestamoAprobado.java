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
import java.util.Date;
import lombok.Data;

/**
 *
 * @author ping_
 */
@Data
@Entity
@Table(name = "prestamos_aprobados", schema = "examenchn")
public class PrestamoAprobado {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_prestamo_aprobado")
    private int idPrestamoAprobado;
    
    @Column(name = "id_cliente")
    private int idCliente;
    
    @Column(name = "estado_prestamo_aprobado")
    private int estadoPrestamoAprobado;
    
    @Column(name = "saldo_pendiente")
    private BigDecimal saldoPendiente;
    
    @Column(name = "fecha_aprobacion")
    private Date fechaAprobacion;
    
    
    
    
    
}
