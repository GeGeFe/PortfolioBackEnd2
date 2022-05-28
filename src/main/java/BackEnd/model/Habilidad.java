/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.model;

// Para que funcione Entity hay que importarlo de javax y no de spring. Lo mismo con GeneratedValue, GenerationType e Id.
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gabriel
 */
@Getter
@Setter
@Entity
public class Habilidad implements Serializable {
    public enum TipoHabilidad {
        Hard, Soft;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_habilidad;
    private String Nombre;
    private Integer Porcentaje;
    
    @Column(columnDefinition = "ENUM('Hard', 'Soft')")
    @Enumerated(EnumType.STRING)
    private Habilidad.TipoHabilidad Tipo;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_persona")
    private Persona id_persona;
}
