/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Formacion;
import BackEnd.model.Persona;
import BackEnd.service.IPersonaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    private IPersonaService ServicioPersona;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return ServicioPersona.getPersonas();
    }

    @CrossOrigin
    @GetMapping("/personas/traer/{id}")
    public Persona getPersona(@PathVariable Integer id) {
        return ServicioPersona.findPersona(id);
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona perso) {
        System.out.println(perso);
        ServicioPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Integer id) {
        ServicioPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Integer id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("fecha_nacimiento") Date nuevaFecha,
            @RequestParam("banner") String nuevoBanner,
            @RequestParam("avatar") String nuevoAvatar,
            @RequestParam("acerca_de") String nuevoAcercade
    ) {
        Persona perso = ServicioPersona.findPersona(id);

        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setFecha_Nacimiento(nuevaFecha);

        ServicioPersona.savePersona(perso);
        return perso;
    }

    @CrossOrigin
    @PostMapping("/personas/{id}/agregarFormacion")
    public String agregarFormacion(@PathVariable Integer id,@RequestBody Formacion unaFormacion) {
        System.out.println(unaFormacion);
        unaFormacion.setId_persona(ServicioPersona.findPersona(id));
        ServicioPersona.agregarFormacion(unaFormacion);
        return "La formacion fue agregada correctamente";
    }

}
