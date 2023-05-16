
package com.proyecto.portfolio.security.dto;


public class JwtDto {
    private String token;
    
    //Constructor

    public JwtDto(String token) {
        this.token = token;
    }
    
    // Getter y Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
