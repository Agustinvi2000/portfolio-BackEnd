package com.proyecto.portfolio.service;

import com.proyecto.portfolio.dto.LoginDTO;
import com.proyecto.portfolio.entity.Login;
import com.proyecto.portfolio.repository.LoginRepo;
import com.proyecto.portfolio.service.LoginService;
import com.proyecto.portfolio.util.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginImpl implements LoginService {
    @Autowired
    private LoginRepo loginRepo;


//    LoginDTO loginDTO;

    @Override
    public LoginResponse loginResponse(LoginDTO loginDTO) {
//        String msg = "";
        Login login = loginRepo.findByNombreUsuario(loginDTO.getNombreUsuario());
        if (login != null) {
            String password = loginDTO.getPassword();

            String storedPassword = login.getPassword();

            Boolean isPwdRight = password.matches(storedPassword);            
            
            if (isPwdRight) {
                Optional<Login> user = loginRepo.findOneByNombreUsuarioAndPassword(loginDTO.getNombreUsuario(), storedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
