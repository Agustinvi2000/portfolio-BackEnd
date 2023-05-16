
package com.proyecto.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity  /* creo una entidad */
@Getter @Setter
@Table(name = "trabajos")
public class Experiencia {
        
    @Id /* agrego esto  */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* agrego esto  */
    private int id;
    
    @NotNull
    private String empresa;
    
    private String logo;
    
    private String url;
    
    @NotNull
    private String puesto;
    
    private String tipo_empleo;

    @Column(length = 2000)
    @NotNull
    private String ubicacion;

    private String tipo_ubicacion;
    
    @Temporal(TemporalType.TIMESTAMP) /* agrego esto  */
    @NotNull
    private Date inicio;

    @Temporal(TemporalType.TIMESTAMP) /* agrego esto  */
    private Date fin;
    
    private boolean Actual;
   
    @Column(length = 2000)
    private String descripcion;
       
    
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

    public Experiencia() {
    }

    public Experiencia(String empresa, String logo, String url, String puesto, String tipo_empleo, String ubicacion, String tipo_ubicacion, Date inicio, Date fin, boolean Actual, String descripcion, Persona persona) {
        this.empresa = empresa;
        this.logo = logo;
        this.url = url;
        this.puesto = puesto;
        this.tipo_empleo = tipo_empleo;
        this.ubicacion = ubicacion;
        this.tipo_ubicacion = tipo_ubicacion;
        this.inicio = inicio;
        this.fin = fin;
        this.Actual = Actual;
        this.descripcion = descripcion;
        this.persona = persona;
    }



    
    
// Alt + Insert y hago getters y setters de todo (incluyendo id)

       // Opción para que no haga un loop
    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }
    
}
