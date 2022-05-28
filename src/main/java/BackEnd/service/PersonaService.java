/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Experiencia;
import BackEnd.model.Formacion;
import BackEnd.model.Habilidad;
import BackEnd.model.Persona;
import BackEnd.model.Proyecto;
import BackEnd.repository.ExperienciaRepository;
import BackEnd.repository.FormacionRepository;
import BackEnd.repository.HabilidadRepository;
import BackEnd.repository.PersonaRepository;
import BackEnd.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository persoRepository;

    @Autowired
    private FormacionRepository formaRepository;

    @Autowired
    private ExperienciaRepository expoRepository;

    @Autowired
    private ProyectoRepository proyRepository;

    @Autowired
    private HabilidadRepository habilRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepository.save(perso);
    }

    @Override
    public void deletePersona(Integer id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Integer id) {
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void agregarFormacion(Formacion unaFormacion) {
        formaRepository.save(unaFormacion);
    }

    @Override
    public void agregarExperiencia(Experiencia unaExperiencia) {
        expoRepository.save(unaExperiencia);
    }

    @Override
    public void agregarProyecto(Proyecto unProyecto) {
        proyRepository.save(unProyecto);
    }

    @Override
    public void agregarHabilidad(Habilidad unaHabilidad) {
        habilRepository.save(unaHabilidad);
    }

}
