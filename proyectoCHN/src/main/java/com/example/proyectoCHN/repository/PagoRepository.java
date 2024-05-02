/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoCHN.repository;

import com.example.proyectoCHN.models.Pago;
import com.example.proyectoCHN.projections.PagoPrestamoProjection;
import com.example.proyectoCHN.projections.PagoSolicitudAprobadaProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ping_
 */
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query(value = "SELECT pa.id_prestamo_aprobado as idPrestamoAprobado,\n"
            + "	   pa.id_cliente as idCliente,\n"
            + "	   c.nombre as nombre,\n"
            + "	   pa.estado_prestamo_aprobado as estadoPrestamoAprobado,\n"
            + "	   pa.saldo_pendiente as montoSolicitado,\n"
            + "	   pa.fecha_aprobacion as fechaAprobacion,\n"
            + "	   SUM(p.monto_pago) as montoPago,\n"
            + "	   (pa.saldo_pendiente - SUM(p.monto_pago)) as saldo\n"
            + "	   \n"
            + "FROM examenchn.prestamos_aprobados as pa\n"
            + "INNER JOIN examenchn.clientes as c ON c.id_cliente = pa.id_cliente\n"
            + "LEFT JOIN examenchn.pago as p ON p.id_prestamo_aprobado = pa.id_prestamo_aprobado\n"
            + "GROUP BY pa.id_prestamo_aprobado, c.nombre\n"
            + "order by c.nombre", nativeQuery = true)
    List<PagoPrestamoProjection> getPagosClientes();

    @Query(value = "select \n"
            + "	id_pago as idPago,\n"
            + "	id_prestamo_aprobado as idPrestamoAprobado,\n"
            + "	fecha_pago as fechaPago,\n"
            + "	monto_pago as montoPago\n"
            + "from examenchn.pago as p \n"
            + "WHERE id_prestamo_aprobado = :idSolicitudAprobada", nativeQuery = true)
    List<PagoSolicitudAprobadaProjection> getPagosPrestamoAprobado(@Param("idSolicitudAprobada") int idSolicitudAprobada);
}
