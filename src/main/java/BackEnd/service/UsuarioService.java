/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.service;

import BackEnd.model.Usuario;
import BackEnd.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String username) {
        usuarioRepository.deleteById(username);
    }

    @Override
    public Usuario findUsuario(String username) {
        Usuario usuario = usuarioRepository.findById(username).orElse(null);
        return usuario;
    }

    @Override
    public boolean verificaUsuario(Usuario usuario) {
        Usuario avericar = usuarioRepository.findById(usuario.getUsername()).orElse(null);
        return usuario.getPassword().equals(avericar.getPassword());
    }
}
