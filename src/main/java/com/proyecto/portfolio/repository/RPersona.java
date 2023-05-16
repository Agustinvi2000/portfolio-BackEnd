
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /* Annotation de repositorio */
public interface RPersona extends JpaRepository <Persona, Integer> {
    // aca tambien se puede declarar metodos extras
}
