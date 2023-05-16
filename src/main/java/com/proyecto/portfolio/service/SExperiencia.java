
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Experiencia;
import com.proyecto.portfolio.repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    public RExperiencia experRepo;
    
    public List<Experiencia> verTrabajos(){
        List<Experiencia> listaTrabajos= experRepo.findAll();
        return listaTrabajos;        
    }
    
    public Experiencia buscarTrabajo(int id){
        // si no encuentra la experiencia devuelve nulo (null)
        Experiencia exper = experRepo.findById(id).orElse(null);
        return exper;
    }
    
    public void crearTrabajo(Experiencia exper){
        experRepo.save(exper);
    }
    
    public void borrarTrabajo(int id){
        experRepo.deleteById(id);
    }
           
    public void editarTrabajo(Experiencia exper){
        experRepo.save(exper);
    }

}
