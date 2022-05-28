/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Experiencia;
import BackEnd.model.Formacion;
import BackEnd.model.Habilidad;
import BackEnd.model.Persona;
import BackEnd.model.Proyecto;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona perso);

    public void deletePersona(Integer id);

    public Persona findPersona(Integer id);

    public void agregarFormacion(Formacion unaFormacion);

    public void agregarExperiencia(Experiencia unaExperiencia);

    public void agregarProyecto(Proyecto unProyecto);
    
    public void agregarHabilidad(Habilidad unaHabilidad);
}
