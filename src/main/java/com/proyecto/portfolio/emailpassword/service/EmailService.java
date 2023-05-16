
package com.proyecto.portfolio.emailpassword.service;

import com.proyecto.portfolio.emailpassword.dto.ChangePasswordDTO;
import com.proyecto.portfolio.emailpassword.dto.EmailValuesDTO;
import com.proyecto.portfolio.exceptions.CustomException;
import com.proyecto.portfolio.security.controller.Mensaje;
import com.proyecto.portfolio.security.entity.Usuario;
import com.proyecto.portfolio.security.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;
    
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Value("${spring.mail.username}")
    private String mailFrom;
    
    @Value("${mail.subject}")
    private String subject;
    
    public Mensaje sendEmailTemplate(EmailValuesDTO dto){
        Optional<Usuario> usuarioOpt = iusuarioRepository.findByNombreUsuarioOrEmail(dto.getMailTo(),dto.getMailTo());
        if(!usuarioOpt.isPresent())
            throw new CustomException(HttpStatus.NOT_FOUND,"No existe ningún usuario con esas credenciales");
        Usuario usuario = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(usuario.getEmail());
        dto.setSubject(subject);
        dto.setUserName(usuario.getNombreUsuario());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        usuario.setTokenPassword(tokenPassword);
        iusuarioRepository.save(usuario);
        sendEmail(dto);
        return new Mensaje("Te hemos enviado un correo");
    }
    
    public Mensaje changePassword(ChangePasswordDTO dto){
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            throw new CustomException(HttpStatus.BAD_REQUEST,"Las contraseñas no coinciden");
        Optional<Usuario> usuarioOpt = iusuarioRepository.findByTokenPassword(dto.getTokenPassword());
        if(!usuarioOpt.isPresent())
            throw new CustomException(HttpStatus.NOT_FOUND,"No existe ningún uduario con esas credenciales");
        Usuario usuario = usuarioOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(newPassword);
        usuario.setTokenPassword(null);
        iusuarioRepository.save(usuario);
        return new Mensaje("Contraseña actualizada");
    }


    public void sendEmail(EmailValuesDTO dto) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", dto.getUserName());
            model.put("url", urlFront + dto.getTokenPassword());
            context.setVariables(model);
            String htmlText = templateEngine.process("email-template", context);
            helper.setFrom(dto.getMailFrom());
            helper.setTo(dto.getMailTo());
            helper.setSubject(dto.getSubject());
            helper.setText(htmlText, true);

            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
