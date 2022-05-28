/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Habilidad;
import BackEnd.service.IHabilidadService;
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
public class HabilidadController {

    @Autowired
    private IHabilidadService ServicioHabilidad;

    @GetMapping("/habilidad/traer")
    public List<Habilidad> getHabilidad() {
        return ServicioHabilidad.getHabilidad();
    }

    @GetMapping("/habilidad/traer/{id}")
    public Habilidad getHabilidad(@PathVariable Integer id) {
        return ServicioHabilidad.findHabilidad(id);
    }

    @CrossOrigin
    @PostMapping("/habilidad/crear")
    public String createHabilidad(@RequestBody Habilidad habilidad) {
        ServicioHabilidad.saveHabilidad(habilidad);
        return "{}";
    }

    @CrossOrigin
    @DeleteMapping("/habilidad/borrar/{id}")
    public String deleteHabilidad(@PathVariable Integer id) {
        ServicioHabilidad.deleteHabilidad(id);
        return "{}";
    }
}
