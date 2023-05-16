
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface RExperiencia extends JpaRepository <Experiencia, Integer>{
    
}
