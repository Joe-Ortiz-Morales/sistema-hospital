
package com.sistema.hospital.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consultorios implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int NoConsultorio;
    private int piso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoConsultorio() {
        return NoConsultorio;
    }

    public void setNoConsultorio(int NoConsultorio) {
        this.NoConsultorio = NoConsultorio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    public Consultorios(){
        super();
    }
    
    @OneToMany( mappedBy = "consultorio")
    private List<Citas> citas = new ArrayList<>();

    public Consultorios(int NoConsultorio, int piso) {
        this.NoConsultorio = NoConsultorio;
        this.piso = piso;
    }

    

    
    
    
    
}
