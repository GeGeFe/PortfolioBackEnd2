/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Formacion;
import BackEnd.model.Formacion.TipoFormacion;
import BackEnd.service.IFormacionService;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/formacion/crear")
    public String createFormacion(@RequestBody Formacion formacion) {
        ServicioFormacion.saveFormacion(formacion);
        return "La formacion fue creada correctamente";
    }

    @DeleteMapping("/formacion/borrar/{id}")
    public String deleteFormacion(@PathVariable Integer id) {
        ServicioFormacion.deleteFormacion(id);
        return "La formacion fue eliminada correctamente";
    }

    @PutMapping("/formacion/editar/{id}")
    public Formacion editFormacion(@PathVariable Integer id,
            @RequestParam("fecha_inicio") Date nuevaFechaInicio,
            @RequestParam("fecha_final") Date nuevaFechaFinal,
            @RequestParam("institucion") String nuevaInstitucion,
            @RequestParam("logo") String nuevoLogo,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("tipo") TipoFormacion nuevoTipo
    ) {
        Formacion formacion = ServicioFormacion.findFormacion(id);

        formacion.setLogo(nuevoLogo);
        formacion.setFecha_Final(nuevaFechaFinal);
        formacion.setFecha_Inicio(nuevaFechaInicio);
        formacion.setInstitucion(nuevaInstitucion);
        formacion.setTitulo(nuevoTitulo);
        formacion.setTipo(nuevoTipo);
                
        ServicioFormacion.saveFormacion(formacion);
        return formacion;
    }
}
