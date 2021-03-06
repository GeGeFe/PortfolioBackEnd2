/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Formacion;
import BackEnd.service.IFormacionService;
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
public class FormacionController {

    @Autowired
    private IFormacionService ServicioFormacion;

    @GetMapping("/formacion/traer")
    public List<Formacion> getFormacion() {
        return ServicioFormacion.getFormacion();
    }

    @GetMapping("/formacion/traer/{id}")
    public Formacion getFormacion(@PathVariable Integer id) {
        return ServicioFormacion.findFormacion(id);
    }

    @CrossOrigin
    @PostMapping("/formacion/crear")
    public String createFormacion(@RequestBody Formacion formacion) {
        ServicioFormacion.saveFormacion(formacion);
        return "{}";
    }

    @CrossOrigin
    @DeleteMapping("/formacion/borrar/{id}")
    public String deleteFormacion(@PathVariable Integer id) {
        ServicioFormacion.deleteFormacion(id);
        return "{}";
    }
}
