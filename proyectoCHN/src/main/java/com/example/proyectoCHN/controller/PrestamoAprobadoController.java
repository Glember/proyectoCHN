/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.controller;

import com.example.proyectoCHN.models.PrestamoAprobado;
import com.example.proyectoCHN.services.PrestamoAprobadoService;
import java.util.List;
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

/**
 *
 * @author ping_
 */
@RestController
@RequestMapping(path = "/api/prestamosAprobados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrestamoAprobadoController {
    
     @Autowired
    PrestamoAprobadoService prestamoAprobadoService;

    @GetMapping(path = "/getPrestamosAprobadosAll")
    public List<PrestamoAprobado> getPrestamosAprobadosAll() {
        return prestamoAprobadoService.getPrestamosAprobadosAll();
    }

    @GetMapping(path ="/getPrestamoAprobado/{prestamoAprobadoId}")
    public Optional<PrestamoAprobado> getPrestamoAprobado(@PathVariable("prestamoAprobadoId") Integer prestamoAprobadoId) {
        return prestamoAprobadoService.getPrestamoAprobado(prestamoAprobadoId);
    }

    @PostMapping(path = "/saveOrUpdatePrestamoAprobado")
    public String saveOrUpdateCliente(@RequestBody PrestamoAprobado prestamoAprobadoId) {
        prestamoAprobadoService.guardarPrestamoAprobado(prestamoAprobadoId);
        return "Exito";
    }

    @DeleteMapping(path = "/deletePrestamoAprobado/{clienteId}")
    public String deleteCliente(@PathVariable("clienteId") Integer prestamoAprobadoId) {
        prestamoAprobadoService.deletePrestamoAprobado (prestamoAprobadoId);
        return "Exito";
    }
    
}
