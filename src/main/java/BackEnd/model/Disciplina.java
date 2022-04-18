/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.model;

// Para que funcione Entity hay que importarlo de javax y no de spring. Lo mismo con GeneratedValue, GenerationType e Id.
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gabriel
 */
@Getter
@Setter
@Entity
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_disciplina;
    private String Nombre;

    public Disciplina() {
    }

    /*    public Disciplina(String Nombre) {
        this.Nombre = Nombre;
    }*/
}
