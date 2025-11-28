package com.ecommerce.productos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

	@Configuration
	public class SecurityConfig {

	    /**
	     * Define la cadena de filtros de seguridad. 
	     * En este caso, deshabilita CSRF y permite todas las peticiones sin autenticación.
	     * La configuración CORS se aplica a través del CorsConfigurationSource Bean.
	     */
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
	            .cors(cors -> cors.configurationSource(corsConfigurationSource())); // Aplica la configuración CORS

	        return http.build();
	    }

	    /**
	     * Bean para configurar CORS (Cross-Origin Resource Sharing).
	     * ⚠️ Esta configuración usa allowedOriginPatterns junto con allowCredentials(true), 
	     * que es la forma correcta de evitar el error "allowedOrigins cannot contain the special value '*'".
	     */
	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();

	        // **USO CORRECTO:** Usamos setAllowedOriginPatterns() en lugar de setAllowedOrigins().
	        // Es mejor práctica listar solo los orígenes conocidos y necesarios.
	        configuration.setAllowedOriginPatterns(List.of(
	            "http://localhost:3000",  // Origen de ejemplo para React/Vue
	            "http://localhost:4200",  // Origen de ejemplo para Angular
	            "http://localhost:8080",  // Origen de ejemplo si tienes un frontend simple
	            "null"                    // Necesario a veces para probar archivos locales (file://)
	        ));

	        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
	        configuration.setAllowedHeaders(List.of("*"));
	        
	        // **IMPORTANTE:** Si usas cabeceras de autorización (tokens) o cookies.
	        configuration.setAllowCredentials(true); 

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration); // Aplica esta configuración a todas las rutas

	        return source;
	    }
	}

