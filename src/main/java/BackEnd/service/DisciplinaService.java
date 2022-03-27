/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Disciplina;
import BackEnd.repository.DisciplinaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class DisciplinaService implements IDisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> getDisciplinas() {
        List<Disciplina> listaDisciplinas = disciplinaRepository.findAll();
        return listaDisciplinas;
    }

    @Override
    public void saveDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    @Override
    public void deleteDisciplina(Integer id) {
        disciplinaRepository.deleteById(id);
    }

    @Override
    public Disciplina findDisciplina(Integer id) {
        Disciplina disciplina = disciplinaRepository.findById(id).orElse(null);
        return disciplina;
    }
}
