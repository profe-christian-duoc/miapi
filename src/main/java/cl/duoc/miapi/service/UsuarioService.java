package cl.duoc.miapi.service;

import cl.duoc.miapi.model.Usuario;
import cl.duoc.miapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // 1. Listar todos
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // 2. Buscar por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // 3. Registrar (Crear)
    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 4. Borrar
    public boolean borrar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // 5. Actualizar
    public Usuario actualizar(Long id, Usuario usuarioDetalles) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setApellido(usuarioDetalles.getApellido());
            usuario.setEdad(usuarioDetalles.getEdad());
            usuario.setTipo(usuarioDetalles.getTipo());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }
}
