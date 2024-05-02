/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.services;

import com.example.proyectoCHN.models.PrestamoAprobado;
import com.example.proyectoCHN.repository.PrestamoAprobadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ping_
 */
@Service
public class PrestamoAprobadoService {
    
    @Autowired
    PrestamoAprobadoRepository prestamosAprobadosRepository;

    public List<PrestamoAprobado> getPrestamosAprobadosAll() {
        return prestamosAprobadosRepository.findAll();
    };

    public Optional<PrestamoAprobado> getPrestamoAprobado(Integer id) {
        return prestamosAprobadosRepository.findById(id);
    }

    public void guardarPrestamoAprobado(PrestamoAprobado prestamoAprobado) {
        prestamosAprobadosRepository.save(prestamoAprobado);
    }

    public void deletePrestamoAprobado(Integer id) {
        prestamosAprobadosRepository.deleteById(id);
    }
}
