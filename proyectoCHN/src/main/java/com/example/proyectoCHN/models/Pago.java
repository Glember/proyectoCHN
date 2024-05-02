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
@Table(name = "pago", schema = "examenchn")
public class Pago {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pago")
    private int idPago;
    
    @Column(name = "id_prestamo_aprobado")
    private int idPrestamoAprobado;
    
    @Column(name = "monto_pago")
    private BigDecimal montoPago;
    
    @Column(name = "fecha_pago")
    private Date fechaPago;
    
}
