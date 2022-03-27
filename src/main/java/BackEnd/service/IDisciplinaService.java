/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Disciplina;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IDisciplinaService {

    public List<Disciplina> getDisciplinas();

    public void saveDisciplina(Disciplina disciplina);

    public void deleteDisciplina(Integer id);

    public Disciplina findDisciplina(Integer id);
}
