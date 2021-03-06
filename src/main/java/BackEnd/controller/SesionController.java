/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Usuario;
import BackEnd.service.IUsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author gabriel
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class SesionController {

    @Autowired
    private IUsuarioService ServicioUsuario;

    @Value("${jwt.secret}") // jwt.secret está definido en application.properties
    private String SECRET;

    @Value("${jwt.expiration}") // jwt.expiration está definido en application.properties
    private int expiration;

    @PostMapping("/sesionInicio")
    public Usuario sesionInicio(@RequestBody Usuario miusuario) {

        if (ServicioUsuario.verificaUsuario(miusuario)) {
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_USER");

            String token = "Bearer " + Jwts.builder()
                    .setId("softtekJWT")
                    .setSubject(miusuario.getUsername())
                    .claim("authorities",
                            grantedAuthorities.stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .collect(Collectors.toList()))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(SignatureAlgorithm.HS512,
                            SECRET.getBytes()).compact();
            miusuario.setToken(token);
            return miusuario;
        } else {
            return null;
        }
    }

    @CrossOrigin
    @PostMapping("/sesionInicioIrrestricto")
    public Usuario sesionInicioIrrestricto(@RequestBody Usuario miusuario) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = "Bearer " + Jwts.builder()
                .setId("softtekJWT")
                .setSubject(miusuario.getUsername())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512,
                        SECRET.getBytes()).compact();
        miusuario.setToken(token);
        return miusuario;
    }
}
