
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.entity.Redes;
import com.proyecto.portfolio.service.SRedes;
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
@RequestMapping("redes")  //localhost:8080/redes
//@CrossOrigin(origins = "http://localhost:4200") //es localhost:4200 pues es el que uso para Angular*/
@CrossOrigin(origins = "https://portfolio-avi.web.app")
public class CRedes {
    @Autowired
    SRedes redServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Redes> verRedes(){
        return redServ.verRedes();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Redes verRed(@PathVariable int id){
        return redServ.buscarRed(id);
    }
    
    @PostMapping("/crear")
    public void agregarRed (@RequestBody Redes redes){
        redServ.crearRed(redes);
       // return "La red fue creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public void eliminarRed(@PathVariable int id){
        redServ.borrarRed(id);
       // return "La red fue borrada correctamente";
    }
    
    // otra forma de editar redes
    @PutMapping("/editar")
    public void updateRed(@RequestBody Redes redes){
        redServ.editarRed(redes);
    }
}
