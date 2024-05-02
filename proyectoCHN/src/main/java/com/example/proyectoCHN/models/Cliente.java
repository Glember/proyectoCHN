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
import lombok.Data;

/**
 *
 * @author ping_
 */
@Data
@Entity
@Table(name = "clientes", schema = "examenchn")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "apellido", length = 15)
    private String apellido;

    @Column(name = "numero_identificacion", length = 15)
    private String numeroIdentificacion;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "telefono", length = 8)
    private String telefono;
}
