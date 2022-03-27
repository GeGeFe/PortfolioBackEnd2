/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Formacion;
import BackEnd.repository.FormacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class FormacionService implements IFormacionService {

    @Autowired
    private FormacionRepository formacionRepository;

    @Override
    public List<Formacion> getFormacion() {
        List<Formacion> listaFormacion = formacionRepository.findAll();
        return listaFormacion;
    }

    @Override
    public void saveFormacion(Formacion formacion) {
        formacionRepository.save(formacion);
    }

    @Override
    public void deleteFormacion(Integer id) {
        formacionRepository.deleteById(id);
    }

    @Override
    public Formacion findFormacion(Integer id) {
        Formacion formacion = formacionRepository.findById(id).orElse(null);
        return formacion;
    }
}
