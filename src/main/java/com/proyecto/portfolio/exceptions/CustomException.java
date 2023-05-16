
package com.proyecto.portfolio.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    
    private HttpStatus status;

    //Constructor
    public CustomException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    
    //Getter

    public HttpStatus getStatus() {
        return status;
    }
    
}
