
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface RHabilidades extends JpaRepository <Habilidades, Integer>{
    
}
