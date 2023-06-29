package com.proyecto.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "nombre de usuario/email obligatorio")
    private String nombreUsuario;
    @NotBlank(message = "contraseña obligatoria")
    private String password;    
    
    
    public LoginDTO() {
    }

       
    public LoginDTO(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    
    //Getter y Setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
