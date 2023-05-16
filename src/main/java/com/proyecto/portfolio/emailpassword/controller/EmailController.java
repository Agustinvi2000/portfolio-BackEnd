
package com.proyecto.portfolio.emailpassword.controller;

import com.proyecto.portfolio.emailpassword.dto.ChangePasswordDTO;
import com.proyecto.portfolio.emailpassword.dto.EmailValuesDTO;
import com.proyecto.portfolio.emailpassword.service.EmailService;
import com.proyecto.portfolio.security.controller.Mensaje;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

    @Autowired
    EmailService emailService;
    
    @PostMapping("/send-email")
    public ResponseEntity<Mensaje> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
/*        Optional<Usuario> usuarioOpt = usuarioService.getByNombreUsuarioOrEmail(dto.getMailTo());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún uduario con esas credenciales"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(usuario.getEmail());
        dto.setSubject(subject);
        dto.setUserName(usuario.getNombreUsuario());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        usuario.setTokenPassword(tokenPassword);
        usuarioService.save(usuario);
        emailService.sendEmail(dto); */
        return ResponseEntity.ok(emailService.sendEmailTemplate(dto));
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<Mensaje> changePassword(@Valid @RequestBody ChangePasswordDTO dto){
/*        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            return new ResponseEntity(new Mensaje("Las contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
        Optional<Usuario> usuarioOpt = usuarioService.getByTokenPassword(dto.getTokenPassword());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún uduario con esas credenciales"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(newPassword);
        usuario.setTokenPassword(null);
        usuarioService.save(usuario);*/
        return ResponseEntity.ok(emailService.changePassword(dto));
    }
}