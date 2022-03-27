/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Persona;
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
}
