
package com.proyecto.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


// Ctrl + Shift + i ==> veo todo lo que hay q importar

@Entity  /* creo una entidad */
@Getter @Setter
@Table(name = "persona")
public class Persona {
    
    @Id /* agrego esto.  */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* agrego esto  */
    private int id;
    
    // agrego a todo esto "final"
    private String banner;
    
    private String foto;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @Temporal(TemporalType.DATE) // agrego esto  
    @NotNull
    private Date nacimiento;
    
    private String titular;
    
    // @Lob deberia dar un longtext agrego esto pues es un texto largo a diferencia de nombre y apellido que tiene 255 caracteres como máximo  
    // El annotation @Column(Length=1000) significa que me permite escribir hasta 1000 caracteres.
    // El annotation @Size(min = 1, max = 400, message = "no cumple con la longitud") delimita el largo del texto y se usa si no anda @Lob por ejemplo
    @Column(length = 2000)
    @NotNull
    private String ubicacion;
    
    private String telefono;
    /*
    @Email
    private String email;
    
    private String password;
    */
    @Column(length = 2000)
    private String about;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Educacion> estudios;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Experiencia> trabajos;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Habilidades> habilidades;    

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Proyectos> proyectos;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Redes> redes;    
    
    
    
    public Persona() {
    }
    

    
       
        /*
        estudios= new ArrayList();
        trabajos= new ArrayList();
        proyectos= new ArrayList();
        habilidades= new ArrayList();
        redes= new ArrayList();
        */

    public Persona(String banner, String foto, String nombre, String apellido, Date nacimiento, String titular, String ubicacion, String telefono, String about, List<Educacion> estudios, List<Experiencia> trabajos, List<Habilidades> habilidades, List<Proyectos> proyectos, List<Redes> redes) {
        this.banner = banner;
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.titular = titular;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.about = about;
        this.estudios = estudios;
        this.trabajos = trabajos;
        this.habilidades = habilidades;
        this.proyectos = proyectos;
        this.redes = redes;
    }
        



    
    //cortar el loop en una unica relacion
    @JsonManagedReference
    public List<Educacion> getEstudios() {
    return estudios;
    }
    
    @JsonManagedReference
    public List<Experiencia> getTrabajos() {
    return trabajos;
    }
    
    @JsonManagedReference
    public List<Habilidades> getHabilidades() {
    return habilidades;
    }
       
    
    @JsonManagedReference
    public List<Proyectos> getProyectos() {
        return proyectos;
    }
    
    @JsonManagedReference
    public List<Redes> getRedes() {
    return redes;
    }
    
    


// Alt + Insert y hago un constructor con nada y otro constructor con todo menos id.

// Alt + Insert y hago getters y setters de todo (incluyendo id)

    /* Lo hago con lombol (Getter y Setter)*/


    
}
