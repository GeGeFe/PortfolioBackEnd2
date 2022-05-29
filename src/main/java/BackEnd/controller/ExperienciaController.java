/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Experiencia;
import BackEnd.service.IExperienciaService;
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
public class ExperienciaController {

    @Autowired
    private IExperienciaService ServicioExperiencia;

    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia() {
        return ServicioExperiencia.getExperiencia();
    }

    @GetMapping("/experiencia/traer/{id}")
    public Experiencia getExperiencia(@PathVariable Integer id) {
        return ServicioExperiencia.findExperiencia(id);
    }

    @CrossOrigin
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia) {
        ServicioExperiencia.saveExperiencia(experiencia);
        return "{}";
    }

    @CrossOrigin
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Integer id) {
        ServicioExperiencia.deleteExperiencia(id);
        return "{}";
    }
}
