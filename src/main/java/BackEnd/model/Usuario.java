/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.model;

/**
 *
 * @author gabriel
 */
public class Usuario {
    String username;
    String password;
    String token;

    public Usuario(){}
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.token = "";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setToken(String token){
        this.token=token;
    }
    public String getToken(){
        return this.token;
    }    
}
