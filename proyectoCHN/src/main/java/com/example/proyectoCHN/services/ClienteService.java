/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.services;

import com.example.proyectoCHN.models.Cliente;
import com.example.proyectoCHN.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ping_
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    };

    public Optional<Cliente> getCliente(Integer id) {
        return clienteRepository.findById(id);
    }

    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
