/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.services;

import com.example.proyectoCHN.models.Pago;
import com.example.proyectoCHN.projections.PagoPrestamoProjection;
import com.example.proyectoCHN.projections.PagoSolicitudAprobadaProjection;
import com.example.proyectoCHN.repository.PagoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ping_
 */
@Service
public class PagoService {
    
    @Autowired
    PagoRepository pagoRepository;

    public List<Pago> getPagosAll() {
        return pagoRepository.findAll();
    };

    public Optional<Pago> getPago(Integer id) {
        return pagoRepository.findById(id);
    }

    public void saveOrUpdatePago(Pago pago) {
        pagoRepository.save(pago);
    }

    public void deletePago(Integer id) {
        pagoRepository.deleteById(id);
    }

    public List<PagoPrestamoProjection> getPagosClienteAllTable() {
        return pagoRepository.getPagosClientes();
    }

    public List<PagoSolicitudAprobadaProjection> getPagoBySoliAprobada(int idSolicitudAprobada) {
        System.out.println("idSolicitudAprobada " + idSolicitudAprobada);
        return pagoRepository.getPagosPrestamoAprobado(idSolicitudAprobada);
    }
    
}
