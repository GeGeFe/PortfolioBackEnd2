/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.model;

// Para que funcione Entity hay que importarlo de javax y no de spring. Lo mismo con GeneratedValue, GenerationType e Id.
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
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
public class Formacion implements Serializable {
    public enum TipoFormacion {
        Primaria, Secundaria, Terciaria, Universitaria, Curso_Capacitación;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_educacion;
    @Column(columnDefinition = "ENUM('Primaria', 'Secundaria', 'Terciaria', 'Universitaria', 'Curso_Capacitación')")
    @Enumerated(EnumType.STRING)
    private TipoFormacion Tipo;
    private String Titulo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Final;
    private String Logo;
    private String Institucion;

    // Por las dudas lo elimino también de acá: CascadeType.MERGE. No sé por que.
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_persona")
    private Persona id_persona;
}
