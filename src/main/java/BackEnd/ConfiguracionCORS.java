/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// Esta clase esta agregada para configurar CORS.
/**
 *
 * @author gabriel
 */
@Configuration
public class ConfiguracionCORS {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS")
                        .allowedOrigins("*")
//.allowedHeaders("Content-Type", "Accept", "X-Requested-With", "remember-me", "Authorization")
                        .allowedHeaders("*")
//                        .allowCredentials(false)
//                        .exposedHeaders("Access-Control-Allow-Origin: *")
                        ;
            }
        };
    }
}
