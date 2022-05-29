/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Usuario;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IUsuarioService {

    public List<Usuario> getUsuarios();

    public void saveUsuario(Usuario usuario);

    public void deleteUsuario(String id);

    public Usuario findUsuario(String id);
    
    public boolean verificaUsuario(Usuario usuario);
}
