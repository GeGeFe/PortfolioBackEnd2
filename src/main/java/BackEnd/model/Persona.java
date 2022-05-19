/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.model;

// Para que funcione Entity hay que importarlo de javax y no de spring. Lo mismo con GeneratedValue, GenerationType e Id.
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gabriel
 */
@Getter
@Setter
@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_persona;
    private String Nombre;
    private String Apellido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Nacimiento;
    private String Banner;
    private String Avatar;
    private String Acerca_de;

    public Persona() {
        this.Acerca_de = "";
        this.Apellido = "";
        this.Avatar = "";
        this.Banner = "";
        this.Fecha_Nacimiento = new Date();
        this.Nombre = "";
        this.formacion = null;
        this.id_persona = 0;
    }
    @JsonManagedReference
    @OneToMany(mappedBy = "id_persona", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Formacion> formacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "id_persona", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Experiencia> experiencia;
}
