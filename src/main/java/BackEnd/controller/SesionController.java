/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.controller;

import BackEnd.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@RestController
public class SesionController {
    @PostMapping("/sesionInicioIrrestricto")
    public Usuario sesion(@RequestBody Usuario miusuario){
        miusuario.setToken("124safde238GGdSAFA.quedificillpm.fasjfdkjadslkf");
        return miusuario;
    }
/*    @PostMapping("/sesionInicioIrrestricto")
    public ResponseEntity sesion(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ){
//       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
    }*/
    
/*    @RequestMapping(value = "/sesionInicioIrrestricto", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity sesion(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ){
//       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
       return new ResponseEntity("{\"msg\":\"¡¡¡Dale pa delante no más!!!\"}",null, HttpStatus.OK);
    }*/
}
