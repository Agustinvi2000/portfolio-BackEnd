package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.LoginDTO;
import com.proyecto.portfolio.service.LoginService;
import com.proyecto.portfolio.util.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = loginService.loginResponse(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}    
