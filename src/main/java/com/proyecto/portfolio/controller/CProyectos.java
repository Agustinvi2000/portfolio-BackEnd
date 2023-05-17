
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.entity.Proyectos;
import com.proyecto.portfolio.service.SProyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectos")  //localhost:8080/proyectos
/*@CrossOrigin(origins = "http://localhost:4200") //es localhost:4200 pues es el que uso para Angular*/
@CrossOrigin
public class CProyectos {
    @Autowired
    SProyectos proyServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Proyectos> verProyectos(){
        return proyServ.verProyectos();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Proyectos verProyecto(@PathVariable int id){
        return proyServ.buscarProyecto(id);
    }
    
    @PostMapping("/crear")
    public String agregarProyecto (@RequestBody Proyectos proye){
        proyServ.crearProyecto(proye);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String eliminarProyecto(@PathVariable int id){
        proyServ.borrarProyecto(id);
        return "El proyecto fue borrado correctamente";
    }
    
    // otra forma de editar proyecto
    @PutMapping("/editar")
    public void updateProyecto(@RequestBody Proyectos proye){
        proyServ.editarProyecto(proye);
    }
}
