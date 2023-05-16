
package com.proyecto.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity  /* creo una entidad */
@Getter @Setter
@Table(name = "redes")
public class Redes {
    
    @Id /* agrego esto  */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* agrego esto  */
    private int id;
    
    private String icono;
    
    @NotNull
    private String url;
    
    
     //relacion
    @ManyToOne()
    // creacion de columna con llave foránea
    @JoinColumn(name = "persona_id", insertable=false, updatable=false)
    // para que se borre si se borra la persona
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    // acá se unen las 2 tablas
    private Integer persona_id;    
    // Alt + Insert y hago un constructor con nada y otro constructor con todo menos id.

    public Redes() {
    }

    public Redes(String icono, String url, Persona persona) {
        this.icono = icono;
        this.url = url;
        this.persona = persona;
    }


     // Opción para que no haga un loop
    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }   


    
}
