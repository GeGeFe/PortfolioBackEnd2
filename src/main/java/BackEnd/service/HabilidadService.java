/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Habilidad;
import BackEnd.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> getHabilidad() {
        List<Habilidad> listaHabilidad = habilidadRepository.findAll();
        return listaHabilidad;
    }

    @Override
    public void saveHabilidad(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Integer id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public Habilidad findHabilidad(Integer id) {
        Habilidad habilidad = habilidadRepository.findById(id).orElse(null);
        return habilidad;
    }
}
