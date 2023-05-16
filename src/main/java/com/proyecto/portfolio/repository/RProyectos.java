
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface RProyectos extends JpaRepository <Proyectos, Integer>{
    
}
