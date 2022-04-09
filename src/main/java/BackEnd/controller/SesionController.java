/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author gabriel
 */
@RestController
public class SesionController {

    @PostMapping("/sesionInicioIrrestricto")
    public Usuario sesion(@RequestBody Usuario miusuario) {

        String secretKey = "mySecretKey";
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
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        miusuario.setToken(token);
        return miusuario;
    }
}