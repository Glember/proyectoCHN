package com.example.proyectoCHN.controller;

import com.example.proyectoCHN.models.Cliente;
import com.example.proyectoCHN.services.ClienteService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ping_
 */
@RestController
@RequestMapping(path = "/api/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    

    @Autowired
    ClienteService clienteService;

    @GetMapping(path = "/getClienteAll")
    public Map<String, Object> getClienteAll() {
        Map<String, Object> respuestaListCliente = new HashMap<>();

        try {
            respuestaListCliente.put("estado", "exito");
            respuestaListCliente.put("data", clienteService.getClientes());

            return respuestaListCliente;

        } catch (Exception e) {
            respuestaListCliente.put("estado", "error");
            return respuestaListCliente;
        }

    }

    @GetMapping(path = "/getCliente/{clienteId}")
    public Optional<Cliente> getClienteId(@PathVariable("clienteId") Integer clienteId) {

        return clienteService.getCliente(clienteId);
    }

    @PostMapping(path = "/guardarCliente")
    public Map<String, String> saveOrUpdateCliente(@RequestBody Cliente cliente) {
        Map<String, String> respuestaCliente = new HashMap<>();

        try {
            respuestaCliente.put("estado", "exito");
            clienteService.guardarCliente(cliente);
            return respuestaCliente;
        } catch (Exception e) {
            respuestaCliente.put("estado", "error");
            return respuestaCliente;
        }
    }

    @DeleteMapping(path = "/eliminarCliente/{clienteId}")
    public Map<String, String> deleteCliente(@PathVariable("clienteId") Integer clienteId) {
        Map<String, String> eliminarCliente = new HashMap<>();

        try {

            eliminarCliente.put("estado", "exito");
            clienteService.deleteCliente(clienteId);
            return eliminarCliente;

        } catch (Exception e) {

            eliminarCliente.put("estado", "error");
            return eliminarCliente;

        }

    }
}
