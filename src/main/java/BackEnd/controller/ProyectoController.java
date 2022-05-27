/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Proyecto;
import BackEnd.service.IProyectoService;
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
public class ProyectoController {

    @Autowired
    private IProyectoService ServicioProyecto;

    @GetMapping("/proyecto/traer")
    public List<Proyecto> getProyecto() {
        return ServicioProyecto.getProyecto();
    }

    @GetMapping("/proyecto/traer/{id}")
    public Proyecto getProyecto(@PathVariable Integer id) {
        return ServicioProyecto.findProyecto(id);
    }

    @CrossOrigin
    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto) {
        ServicioProyecto.saveProyecto(proyecto);
        return "{}";
    }

    @CrossOrigin
    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Integer id) {
        ServicioProyecto.deleteProyecto(id);
        return "{}";
    }
}
