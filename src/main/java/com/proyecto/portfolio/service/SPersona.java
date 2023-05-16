
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Persona;
import com.proyecto.portfolio.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    @Autowired
    public RPersona persoRepo;
    
    public List<Persona> verPersonas(){
        List<Persona> listaPersonas= persoRepo.findAll();
        return listaPersonas;        
    }
    
    public Persona buscarPersona(int id){
        // si no encuentra la persona devuelve nulo (null)
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }
    
    public void crearPersona(Persona perso){
        persoRepo.save(perso);
    }
    
    public void borrarPersona(int id){
        persoRepo.deleteById(id);
    }
           
    public void editarPersona(Persona perso){
        persoRepo.save(perso);
    }
    
}
