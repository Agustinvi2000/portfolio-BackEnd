package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.entity.Experiencia;
import com.proyecto.portfolio.service.SExperiencia;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("trabajos")  //localhost:8080/trabajos
//@CrossOrigin(origins = "http://localhost:4200") //es localhost:4200 pues es el que uso para Angular*/
@CrossOrigin
public class CExperiencia {

    @Autowired
    SExperiencia experServ;

    @GetMapping("/lista")
    @ResponseBody
    public List<Experiencia> verTrabajos() {
        return experServ.verTrabajos();
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Experiencia verTrabajo(@PathVariable int id) {
        return experServ.buscarTrabajo(id);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public void agregarTrabajo(@RequestBody Experiencia expe) {
        experServ.crearTrabajo(expe);
//        return "El trabajo fue creado correctamente";
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void eliminarTrabajo(@PathVariable int id) {
        experServ.borrarTrabajo(id);
//        return "El trabajo fue borrado correctamente";
    }

    // otra forma de editar experiencia
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void updateTrabajo(@RequestBody Experiencia expe) {
        experServ.editarTrabajo(expe);
    }

    @Autowired
    private ServletContext servletContext;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String relativePath = "/";
            String absolutePath = servletContext.getRealPath(relativePath);
            java.nio.file.Path filePath = Paths.get(absolutePath, fileName);
            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("Archivo cargado con éxito." + absolutePath);
        } catch (IOException e) {
            String relativePath = "/assets/img/images/";
            String absolutePath = servletContext.getRealPath(relativePath);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar el archivo." + absolutePath);
        }
    }
}
