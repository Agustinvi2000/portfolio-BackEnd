
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.entity.Habilidades;
import com.proyecto.portfolio.service.SHabilidades;
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
@RequestMapping("habilidades")  //localhost:8080/habilidades
/*@CrossOrigin(origins = "http://localhost:4200") //es localhost:4200 pues es el que uso para Angular*/
@CrossOrigin
public class CHabilidades {
    @Autowired
    SHabilidades habilServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Habilidades> verHabilidades(){
        return habilServ.verHabilidades();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Habilidades verHabilidad(@PathVariable int id){
        return habilServ.buscarHabilidad(id);
    }
    
    @PostMapping("/crear")
    public String agregarHabilidad (@RequestBody Habilidades hibili){
        habilServ.crearHabilidad(hibili);
        return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String eliminarHabilidad(@PathVariable int id){
        habilServ.borrarHabilidad(id);
        return "La habilidad fue borrada correctamente";
    }
    
    // otra forma de editar habilidad
    @PutMapping("/editar")
    public void updateHabilidad(@RequestBody Habilidades hibili){
        habilServ.editarHabilidad(hibili);
    }
}
