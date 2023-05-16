
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
@Table(name = "estudios")
public class Educacion {
            
    @Id /* agrego esto  */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* agrego esto  */
    private int id;
    
    @NotNull
    private String institucion;
    
    @NotNull
    private String titulo;
    
    private String logo;
    
    @Temporal(TemporalType.DATE) /* agrego esto  */
    @NotNull
    private Date inicio;

    @Temporal(TemporalType.DATE) /* agrego esto  */
    @NotNull
    private Date fin;
   
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

    public Educacion() {
    }

    public Educacion(String institucion, String titulo, String logo, Date inicio, Date fin, String descripcion, Persona persona) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.logo = logo;
        this.inicio = inicio;
        this.fin = fin;
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
