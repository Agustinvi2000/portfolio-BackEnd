
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.entity.Proyectos;
import com.proyecto.portfolio.repository.RProyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    @Autowired
    public RProyectos proyRepo;
    
    public List<Proyectos> verProyectos(){
        List<Proyectos> listaProyectos= proyRepo.findAll();
        return listaProyectos;        
    }
    
    public Proyectos buscarProyecto(int id){
        // si no encuentra el proyecto devuelve nulo (null)
        Proyectos proy = proyRepo.findById(id).orElse(null);
        return proy;
    }
    
    public void crearProyecto(Proyectos proy){
        proyRepo.save(proy);
    }
    
    public void borrarProyecto(int id){
        proyRepo.deleteById(id);
    }
           
    public void editarProyecto(Proyectos proy){
        proyRepo.save(proy);
    }

}
