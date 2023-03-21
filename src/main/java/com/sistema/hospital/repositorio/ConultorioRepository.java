
package com.sistema.hospital.repositorio;

import com.sistema.hospital.modelo.Consultorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConultorioRepository extends JpaRepository<Consultorios, Long>{
    
}
