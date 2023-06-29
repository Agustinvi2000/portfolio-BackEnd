
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.entity.Educacion;
import com.proyecto.portfolio.service.SEducacion;
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
@RequestMapping("estudios")  //localhost:8080/estudios
//@CrossOrigin(origins = "http://localhost:4200") //es localhost:4200 pues es el que uso para Angular
@CrossOrigin
public class CEducacion {
    @Autowired
    SEducacion educaServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Educacion> verEstudios(){
        return educaServ.verEstudios();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Educacion verEstudio(@PathVariable int id){
        return educaServ.buscarEstudio(id);
    }
    
    @PostMapping("/crear")
    public void agregarEstudio (@RequestBody Educacion educ){
        educaServ.crearEstudio(educ);
       // return "El estudio fue creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public void eliminarEstudio(@PathVariable int id){
        educaServ.borrarEstudio(id);
      //  return "El estudio fue borrado correctamente";
    }
    
    // otra forma de editar educacion
    @PutMapping("/editar")
    public void updateEstudio(@RequestBody Educacion educ){
        educaServ.editarEstudio(educ);
    }
}
