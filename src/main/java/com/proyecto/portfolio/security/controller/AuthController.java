
package com.proyecto.portfolio.security.controller;

import com.proyecto.portfolio.security.dto.JwtDto;
import com.proyecto.portfolio.security.dto.LoginUsuario;
import com.proyecto.portfolio.security.dto.NuevoUsuario;
import com.proyecto.portfolio.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping("/nuevo")
    public ResponseEntity<Mensaje> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario){
        return ResponseEntity.ok(usuarioService.save(nuevoUsuario));
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario){
        return ResponseEntity.ok(usuarioService.login(loginUsuario));
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException{
        return ResponseEntity.ok(usuarioService.refresh(jwtDto));
    }      
}