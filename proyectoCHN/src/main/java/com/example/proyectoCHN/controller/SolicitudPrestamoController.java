/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.controller;

import com.example.proyectoCHN.models.SolicitudPrestamo;
import com.example.proyectoCHN.services.SolicitudPrestamoService;
import java.util.HashMap;
import java.util.List;
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

/**
 *
 * @author ping_
 */
@RestController
@RequestMapping(path = "/api/solicitudPrestamo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SolicitudPrestamoController {

    @Autowired
    SolicitudPrestamoService solicitudPrestamoService;

    @GetMapping(path = "/getSolicitudesPrestamoAll")
    public List<SolicitudPrestamo> getSolicitudesPrestamoAll() {

        return solicitudPrestamoService.getSolicitudPrestamosAll();
    }

    @GetMapping(path = "/getSolicitudPrestamo/{SolicitudPrestamoId}")
    public Optional<SolicitudPrestamo> getSolicitudPrestamo(@PathVariable("SolicitudPrestamoId") Integer SolicitudPrestamoId) {
        return solicitudPrestamoService.getSolicitudPrestamo(SolicitudPrestamoId);
    }

    @PostMapping(path = "/saveOrUpdateSolicitudPrestamo")
    public Map<String, String> saveOrUpdateSolicitudPrestamo(@RequestBody SolicitudPrestamo SolicitudPrestamoId) {

        Map<String, String> respuestaSolicitudPrestamo = new HashMap<>();

        try {
            respuestaSolicitudPrestamo.put("estado", "exito");
            solicitudPrestamoService.guardarSolicitudPrestamo(SolicitudPrestamoId);
            return respuestaSolicitudPrestamo;
        } catch (Exception e) {
            respuestaSolicitudPrestamo.put("estado", "error");
            return respuestaSolicitudPrestamo;
        }

    }

    @DeleteMapping(path = "/deleteSolicitudPrestamo/{SolicitudPrestamoId}")
    public Map<String, String> deleteSolicitudPrestamo(@PathVariable("SolicitudPrestamoId") Integer SolicitudPrestamoId) {
        Map<String, String> respuestaSolicitudPrestamo = new HashMap<>();

        try {
            respuestaSolicitudPrestamo.put("estado", "exito");
            solicitudPrestamoService.deleteSolicitudPrestamo(SolicitudPrestamoId);
            return respuestaSolicitudPrestamo;
        } catch (Exception e) {
            respuestaSolicitudPrestamo.put("estado", "error");
            return respuestaSolicitudPrestamo;
        }
    }

    @GetMapping(path = "/getSolicitudesPrestamoAllTable")
    public Map<String, Object> getSolicitudesPrestamoAllTable() {

        Map<String, Object> respuestaListClienteAll = new HashMap<>();

        try {
            respuestaListClienteAll.put("estado", "exito");
            respuestaListClienteAll.put("data", solicitudPrestamoService.getSolicitudesPrestamoAllTable());
            return respuestaListClienteAll;
        } catch (Exception e) {
            respuestaListClienteAll.put("estado", "error");
            return respuestaListClienteAll;
        }
    }
}
