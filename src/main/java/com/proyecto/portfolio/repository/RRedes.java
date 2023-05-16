
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface RRedes extends JpaRepository <Redes, Integer>{
    
}
