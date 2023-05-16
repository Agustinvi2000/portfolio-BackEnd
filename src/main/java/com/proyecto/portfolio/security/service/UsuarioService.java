
package com.proyecto.portfolio.security.service;

import com.proyecto.portfolio.exceptions.CustomException;
import com.proyecto.portfolio.security.controller.Mensaje;
import com.proyecto.portfolio.security.dto.JwtDto;
import com.proyecto.portfolio.security.dto.LoginUsuario;
import com.proyecto.portfolio.security.dto.NuevoUsuario;
import com.proyecto.portfolio.security.entity.Rol;
import com.proyecto.portfolio.security.entity.Usuario;
import com.proyecto.portfolio.security.enums.RolNombre;
import com.proyecto.portfolio.security.jwt.JwtProvider;
import com.proyecto.portfolio.security.repository.iUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
  
    public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail){
        return iusuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail,nombreOrEmail);
    }
   
     
    public Optional<Usuario> getByTokenPassword(String tokenPassword){
        return iusuarioRepository.findByTokenPassword(tokenPassword);
    }
  
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public JwtDto login(LoginUsuario loginUsuario){
        Authentication authentication = 
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        return new JwtDto(jwt);
    }

    public JwtDto refresh(JwtDto jwtDto) throws ParseException{
        String token = jwtProvider.refreshToken(jwtDto);
        return new JwtDto(token);
    }

    public Mensaje save(NuevoUsuario nuevoUsuario){
        if(iusuarioRepository.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            throw new CustomException(HttpStatus.BAD_REQUEST,"Ese nombre de usuario ya existe");
  
        if(iusuarioRepository.existsByEmail(nuevoUsuario.getEmail()))
            throw new CustomException(HttpStatus.BAD_REQUEST,"Ese email de usuario ya existe");  
        Usuario usuario = 
                new Usuario(nuevoUsuario.getNombre(),
                        nuevoUsuario.getNombreUsuario(),
                        nuevoUsuario.getEmail(), 
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        iusuarioRepository.save(usuario);
        return new Mensaje(usuario.getNombreUsuario() + " ha sido creado");
    }
}
