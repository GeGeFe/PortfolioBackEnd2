package BackEnd;

import BackEnd.controller.FiltroAutorizacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class BackEnd {

    public static void main(String[] args) {
        SpringApplication.run(BackEnd.class, args);
    }
// Esto es para configurar el acceso. Sale de aquí: https://blog.softtek.com/es/autenticando-apis-con-spring-y-jwt

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new FiltroAutorizacion(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/sesionInicioIrrestricto").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/sesionInicioIrrestricto").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/personas/traer/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/personas/traer").permitAll()
                    .antMatchers(HttpMethod.GET, "/personas/traer/*").permitAll()
                    .anyRequest().authenticated();
        }
    }
}
