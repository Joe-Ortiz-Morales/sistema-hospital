
package com.sistema.hospital.repositorio;

import com.sistema.hospital.modelo.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRespository extends JpaRepository<Doctores, Long>{
    
}
