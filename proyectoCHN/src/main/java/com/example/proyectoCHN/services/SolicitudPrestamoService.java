package com.example.proyectoCHN.services;

import com.example.proyectoCHN.models.PrestamoAprobado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoCHN.repository.SolitudPrestamoRepository;
import com.example.proyectoCHN.models.SolicitudPrestamo;
import com.example.proyectoCHN.projections.SolicitudPrestamoProjection;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudPrestamoService {

    @Autowired
    SolitudPrestamoRepository solicitudPrestamoRepository;
    
    @Autowired
     PrestamoAprobadoService prestamoAprobadoService;

    public List<SolicitudPrestamo> getSolicitudPrestamosAll() {

        return solicitudPrestamoRepository.findAll();

    }
    
    public Optional<SolicitudPrestamo> getSolicitudPrestamo(Integer id){
    
        return solicitudPrestamoRepository.findById(id);
        
    }
    
    public void guardarSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo){
    
        try {
            //funcion para guardar el prestamo
            
            solicitudPrestamoRepository.save(solicitudPrestamo);
            
            if(solicitudPrestamo.getEstadoPrestamo() == 3){
                
                PrestamoAprobado prestamoAprobado = new PrestamoAprobado();
                prestamoAprobado.setIdCliente(solicitudPrestamo.getIdCliente());
                prestamoAprobado.setEstadoPrestamoAprobado(1);
                prestamoAprobado.setSaldoPendiente(solicitudPrestamo.getMontoSolicitado());
                
               prestamoAprobadoService.guardarPrestamoAprobado(prestamoAprobado);
                System.out.println("Se guardo prestamo");
            
                
            }
        } catch (Exception e) {
            
            System.out.println("Error al guardar el prestamo");
            
        }
        
        
        
    }
    
     public void deleteSolicitudPrestamo(Integer id) {
        solicitudPrestamoRepository.deleteById(id);
    }

    public List<SolicitudPrestamoProjection> getSolicitudesPrestamoAllTable() {
        return solicitudPrestamoRepository.getSolicitudesTables();
    }
    
     

}
