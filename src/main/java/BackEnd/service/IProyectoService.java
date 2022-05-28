/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Imagen;
import BackEnd.model.Proyecto;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IProyectoService {

    public List<Proyecto> getProyecto();

    public void saveProyecto(Proyecto proyecto);

    public void deleteProyecto(Integer id);

    public Proyecto findProyecto(Integer id);
    
    public void agregarImagen(Imagen unaImagen);

}
