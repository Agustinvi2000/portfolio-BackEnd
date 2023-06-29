/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.dto.LoginDTO;
import com.proyecto.portfolio.util.LoginResponse;

public interface LoginService {
    LoginResponse loginResponse(LoginDTO loginDTO);    
}
