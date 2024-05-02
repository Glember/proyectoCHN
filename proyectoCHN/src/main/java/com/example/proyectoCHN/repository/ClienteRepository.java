/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoCHN.repository;

import com.example.proyectoCHN.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author ping_
 */

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
