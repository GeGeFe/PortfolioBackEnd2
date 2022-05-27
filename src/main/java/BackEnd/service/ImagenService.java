/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Imagen;
import BackEnd.repository.ImagenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ImagenService implements IImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    public List<Imagen> getImagen() {
        List<Imagen> listaImagen = imagenRepository.findAll();
        return listaImagen;
    }

    @Override
    public void saveImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    @Override
    public void deleteImagen(Integer id) {
        imagenRepository.deleteById(id);
    }

    @Override
    public Imagen findImagen(Integer id) {
        Imagen imagen = imagenRepository.findById(id).orElse(null);
        return imagen;
    }
}
