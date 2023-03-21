
package com.sistema.hospital.controladores;

import com.sistema.hospital.modelo.Citas;
import com.sistema.hospital.modelo.Consultorios;
import com.sistema.hospital.modelo.Doctores;
import com.sistema.hospital.servicio.CitaService;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    
    @Autowired
    private CitaService service;
    
     @PostMapping("/alta-cita")
    public ResponseEntity<Citas> programarCitaMedica(@RequestBody Citas citaMedica, Doctores doctor, Consultorios consultorio, String NPaciente) {
        
        Citas nuevacita = service.altaCita(NPaciente, LocalDate.EPOCH, LocalTime.MIN, LocalTime.MIN, doctor, consultorio);
        
        return ResponseEntity.ok(nuevacita);
        
    }
    
}
