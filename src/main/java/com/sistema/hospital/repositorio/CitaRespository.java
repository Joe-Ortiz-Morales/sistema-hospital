
package com.sistema.hospital.repositorio;

import com.sistema.hospital.modelo.Citas;
import com.sistema.hospital.modelo.Consultorios;
import com.sistema.hospital.modelo.Doctores;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRespository extends JpaRepository<Citas, Long>{
    
    boolean existsByConsultorioAndHoraInicioBetween(Consultorios consultorio, LocalTime horaInicio, LocalTime horaFin );
    
    boolean existsByDoctorAndHoraInicioBetween(Doctores doctor, LocalTime horaInicio, LocalTime horaFin);
    
    boolean existsByNombrePacienteAndFechaCitaBetween(String nombrePaciente, LocalDate fechaInicio, LocalDate fechaFint);
    
    long countByDoctorAndFechaCita(Doctores doctor, LocalDate fechaCita);
}
