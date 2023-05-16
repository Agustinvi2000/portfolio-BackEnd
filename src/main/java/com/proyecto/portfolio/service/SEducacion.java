
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Educacion;
import com.proyecto.portfolio.repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    public REducacion educaRepo;
    
    public List<Educacion> verEstudios(){
        List<Educacion> listaEstudios= educaRepo.findAll();
        return listaEstudios;        
    }
    
    public Educacion buscarEstudio(int id){
        // si no encuentra el estudio devuelve nulo (null)
        Educacion educa = educaRepo.findById(id).orElse(null);
        return educa;
    }
    
    public void crearEstudio(Educacion educa){
        educaRepo.save(educa);
    }
    
    public void borrarEstudio(int id){
        educaRepo.deleteById(id);
    }
           
    public void editarEstudio(Educacion educa){
        educaRepo.save(educa);
    }
    
}
