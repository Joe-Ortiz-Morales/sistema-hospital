
package com.sistema.hospital.servicio;

import com.sistema.hospital.modelo.Citas;
import com.sistema.hospital.modelo.Consultorios;
import com.sistema.hospital.modelo.Doctores;
import com.sistema.hospital.repositorio.CitaRespository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    
    @Autowired
    private CitaRespository repository;
    
    public Citas altaCita(String NPaciente, LocalDate fechaCita,LocalTime horaInicio, LocalTime horaFin ,Doctores doctor, Consultorios consultorio){
        // Validar que no haya otra cita programada para el mismo consultorio en la misma hora
        if (repository.existsByConsultorioAndHoraInicioBetween(consultorio, horaInicio, horaFin)){
            throw new RuntimeException("Ya existe una cita programada para el mismo consultorio en esa hora.");
        }

        // Validar que no haya otra cita programada para el mismo doctor en la misma hora
        if (repository.existsByDoctorAndHoraInicioBetween(doctor, horaInicio, horaFin)) {
            throw new RuntimeException("Ya existe una cita programada para el mismo doctor en esa hora.");
        }

        // Validar que el paciente no tenga otra cita programada en el mismo día y dentro de las dos horas anteriores
        // a la hora de inicio de la nueva cita
        LocalDateTime inicioVentana = LocalDateTime.of(fechaCita, horaInicio.minusHours(2));
        LocalDateTime finVentana = LocalDateTime.of(fechaCita, horaInicio);
        if (repository.existsByNombrePacienteAndFechaCitaBetween(NPaciente, inicioVentana.toLocalDate(),
                finVentana.toLocalDate())) {
            throw new RuntimeException("El paciente ya tiene otra cita programada dentro de la ventana de tiempo.");
        }

        // Validar que el doctor no tenga ya 8 citas programadas para el mismo día
        LocalDate fechaActual = LocalDate.now();
        if (repository.countByDoctorAndFechaCita(doctor, fechaActual) >= 8) {
            throw new RuntimeException("El doctor ya tiene 8 citas programadas para el día de hoy.");
    }
    
        return altaCita(NPaciente, fechaCita, horaInicio, horaFin, doctor, consultorio);
    
}
    
    
    
    
}
