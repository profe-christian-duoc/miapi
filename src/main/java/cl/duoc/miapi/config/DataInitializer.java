package cl.duoc.miapi.config;

import cl.duoc.miapi.model.Usuario;
import cl.duoc.miapi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarDatosDemo(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario usuario1 = new Usuario(null, "Carlos", "Muñoz", 32, "vip");
                Usuario usuario2 = new Usuario(null, "María", "Urrutia", 26, "vip");
                Usuario usuario3 = new Usuario(null, "Antonia", "Saez", 25, "regular");

                usuarioRepository.saveAll(List.of(usuario1, usuario2, usuario3));
            }
        };
    }
}