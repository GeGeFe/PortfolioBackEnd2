/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Habilidad;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IHabilidadService {

    public List<Habilidad> getHabilidad();

    public void saveHabilidad(Habilidad habilidad);

    public void deleteHabilidad(Integer id);

    public Habilidad findHabilidad(Integer id);
}
