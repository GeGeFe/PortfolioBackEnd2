/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Formacion;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IFormacionService {

    public List<Formacion> getFormacion();

    public void saveFormacion(Formacion formacion);

    public void deleteFormacion(Integer id);

    public Formacion findFormacion(Integer id);
}
