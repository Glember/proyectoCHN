/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoCHN.controller;

import com.example.proyectoCHN.models.Pago;
import com.example.proyectoCHN.services.PagoService;
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
@RequestMapping(path = "/api/pago")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping(path = "/getPagosAll")
    public List<Pago> getPagosAll() {
        return pagoService.getPagosAll();
    }

    @GetMapping(path = "/getPago/{pagoId}")
    public Optional<Pago> getPago(@PathVariable("pagoId") Integer pagoId) {
        return pagoService.getPago(pagoId);
    }

    @PostMapping(path = "/saveOrUpdatePago")
    public Map<String, String> saveOrUpdatePago(@RequestBody Pago pago) {

        Map<String, String> respuestaPago = new HashMap<>();

        try {
            respuestaPago.put("estado", "exito");
            pagoService.saveOrUpdatePago(pago);
            return respuestaPago;

        } catch (Exception e) {
            respuestaPago.put("estado", "error");
            return respuestaPago;
        }

    }

    @DeleteMapping(path = "/deletePago/{pagoId}")
    public String deletePago(@PathVariable("pagoId") Integer pagoId) {
        pagoService.deletePago(pagoId);
        return "Exito";
    }

    @GetMapping(path = "/getPagoPrestamosAllTable")
    public Map<String, Object> getPagoPrestamosAllTable() {

        Map<String, Object> pagoPrestamoListAll = new HashMap<>();

        try {
            pagoPrestamoListAll.put("estado", "exito");
            pagoPrestamoListAll.put("data", pagoService.getPagosClienteAllTable());
            return pagoPrestamoListAll;
        } catch (Exception e) {
            pagoPrestamoListAll.put("estado", "error");
            return pagoPrestamoListAll;
        }
    }

    @GetMapping(path = "/getPagoBySolicitudAprobada/{idSolicitudAprobada}")
    public Map<String, Object> getPagoBySolicitudAprobada(@PathVariable("idSolicitudAprobada") int idSolicitudAprobada) {

        Map<String, Object> listPagoBySoliAprobada = new HashMap<>();

        try {
            listPagoBySoliAprobada.put("estado", "exito");
            listPagoBySoliAprobada.put("data", pagoService.getPagoBySoliAprobada(idSolicitudAprobada));
            return listPagoBySoliAprobada;
        } catch (Exception e) {
            listPagoBySoliAprobada.put("estado", "error");
            return listPagoBySoliAprobada;
        }
    }

}
