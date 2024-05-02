/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoCHN.repository;

import com.example.proyectoCHN.models.SolicitudPrestamo;
import com.example.proyectoCHN.projections.SolicitudPrestamoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ping_
 */
public interface SolitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer> {

    @Query(value = """
                   select sp.id_solicitud_prestamo as idSolicitudPrestamo,
                   \t   sp.id_cliente as idCliente,
                   \t   cl.nombre as nombre,
                   \t   sp.monto_solicitado as montoSolicitado,
                   \t   sp.id_plazo_deseado as idPlazoDeseado,
                   \t   sp.estado_prestamo as estado
                   from examenchn.solicitud_prestamos as sp
                   inner join examenchn.clientes as cl on sp.id_cliente = cl.id_cliente
                   order by cl.nombre""", nativeQuery = true)
    List<SolicitudPrestamoProjection> getSolicitudesTables();

}
