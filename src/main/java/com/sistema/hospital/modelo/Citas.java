
package com.sistema.hospital.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Citas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    //@JoinColumn(name = "doctor_id")
    private Doctores doctor;
    
    @ManyToOne
    //@JoinColumn(name = "doctor_id")
    private Consultorios consultorio;
    
    private LocalDate fechainicio;
    
    private LocalDate fechaFin;
    
    private LocalTime horaInicio;
    
    private LocalTime horaFin;

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
    
    
    private String NPaciente;
    
    public Citas(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctores getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctores doctor) {
        this.doctor = doctor;
    }

    public Consultorios getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorios consultorio) {
        this.consultorio = consultorio;
    }

    

    public String getNPaciente() {
        return NPaciente;
    }

    public void setNPaciente(String NPaciente) {
        this.NPaciente = NPaciente;
    }

    public Citas(Doctores doctor, Consultorios consultorio, LocalDate fechainicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, String NPaciente) {
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.fechainicio = fechainicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.NPaciente = NPaciente;
    }

   
    
    
    

   
    
    
    
    
    
    
}
