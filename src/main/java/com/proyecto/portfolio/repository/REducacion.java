
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface REducacion extends JpaRepository <Educacion, Integer>{
    
}
