package cl.duoc.miapi;

import cl.duoc.miapi.model.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {

    @GetMapping
    public List<Usuario> listar(){
        Usuario usuario1 = new Usuario(1L,"Carlos","Muñoz",32,"vip");
        Usuario usuario2 = new Usuario(2L,"María","Urrutia",26,"vip");
        Usuario usuario3 = new Usuario(3L,"Antonia","Saez",25,"regular");
        return List.of(
                usuario1,usuario2,usuario3
        );
    }
}
