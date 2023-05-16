
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Habilidades;
import com.proyecto.portfolio.repository.RHabilidades;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    @Autowired
    public RHabilidades habilRepo;
    
    public List<Habilidades> verHabilidades(){
        List<Habilidades> listaHabilidades= habilRepo.findAll();
        return listaHabilidades;        
    }
    
    public Habilidades buscarHabilidad(int id){
        // si no encuentra la habilidad devuelve nulo (null)
        Habilidades habil = habilRepo.findById(id).orElse(null);
        return habil;
    }
    
    public void crearHabilidad(Habilidades habil){
        habilRepo.save(habil);
    }
    
    public void borrarHabilidad(int id){
        habilRepo.deleteById(id);
    }
           
    public void editarHabilidad(Habilidades habil){
        habilRepo.save(habil);
    }

}
