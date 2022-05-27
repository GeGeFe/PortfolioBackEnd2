/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Imagen;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IImagenService {

    public List<Imagen> getImagen();

    public void saveImagen(Imagen imagen);

    public void deleteImagen(Integer id);

    public Imagen findImagen(Integer id);
}
