/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Disciplina;
import BackEnd.service.IDisciplinaService;
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
public class DisciplinaController {

    @Autowired
    private IDisciplinaService ServicioDisciplina;

    @GetMapping("/disciplina/traer")
    public List<Disciplina> getPersonas() {
        return ServicioDisciplina.getDisciplinas();
    }

    @GetMapping("/disciplina/traer/{id}")
    public Disciplina getDisciplina(@PathVariable Integer id) {
        return ServicioDisciplina.findDisciplina(id);
    }

    @PostMapping("/disciplina/crear")
    public String createDisciplina(@RequestBody Disciplina disciplina) {
        ServicioDisciplina.saveDisciplina(disciplina);
        return "La disciplina fue creada correctamente";
    }

    @DeleteMapping("/disciplina/borrar/{id}")
    public String deletePersona(@PathVariable Integer id) {
        ServicioDisciplina.deleteDisciplina(id);
        return "La disciplina fue eliminada correctamente";
    }

    @PutMapping("/disciplina/editar/{id}")
    public Disciplina editPersona(@PathVariable Integer id,
            @RequestParam("nombre") String nuevoNombre
    ) {
        Disciplina disciplina = ServicioDisciplina.findDisciplina(id);

        disciplina.setNombre(nuevoNombre);
        ServicioDisciplina.saveDisciplina(disciplina);
        return disciplina;
    }
}
