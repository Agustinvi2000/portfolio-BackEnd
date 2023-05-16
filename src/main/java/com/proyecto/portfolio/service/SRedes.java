
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Redes;
import com.proyecto.portfolio.repository.RRedes;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedes {
    @Autowired
    public RRedes redRepo;
    
    public List<Redes> verRedes(){
        List<Redes> listaRedes= redRepo.findAll();
        return listaRedes;        
    }
    
    public Redes buscarRed(int id){
        // si no encuentra la red devuelve nulo (null)
        Redes red = redRepo.findById(id).orElse(null);
        return red;
    }
    
    public void crearRed(Redes red){
        redRepo.save(red);
    }
    
    public void borrarRed(int id){
        redRepo.deleteById(id);
    }
           
    public void editarRed(Redes red){
        redRepo.save(red);
    }

}
