/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Proyecto;
import BackEnd.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> listaProyecto = proyectoRepository.findAll();
        return listaProyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Integer id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Integer id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
}
