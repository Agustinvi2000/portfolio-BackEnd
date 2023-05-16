
package com.proyecto.portfolio.security.service;

import com.proyecto.portfolio.security.entity.Usuario;
import com.proyecto.portfolio.security.entity.UsuarioPrincipal;
import com.proyecto.portfolio.security.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    iUsuarioRepository iusuarioRepository; 

    @Override
    public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
        Usuario usuario = iusuarioRepository
                .findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail)
                .orElseThrow(()-> new UsernameNotFoundException("ese usuario no existe"));
        return UsuarioPrincipal.build(usuario);        
    }
    
    
}
