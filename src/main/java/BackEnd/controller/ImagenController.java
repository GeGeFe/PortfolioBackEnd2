/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Imagen;
import BackEnd.service.IImagenService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@RestController
public class ImagenController {

    @Autowired
    private IImagenService ServicioImagen;

    @GetMapping("/imagen/traer")
    public List<Imagen> getImagen() {
        return ServicioImagen.getImagen();
    }

    @GetMapping("/imagen/traer/{id}")
    public Imagen getImagen(@PathVariable Integer id) {
        return ServicioImagen.findImagen(id);
    }

    @CrossOrigin
    @PostMapping("/imagen/crear")
    public String createImagen(@RequestBody Imagen imagen) {
        ServicioImagen.saveImagen(imagen);
        return "{}";
    }

    @CrossOrigin
    @DeleteMapping("/imagen/borrar/{id}")
    public String deleteImagen(@PathVariable Integer id) {
        ServicioImagen.deleteImagen(id);
        return "{}";
    }
}
