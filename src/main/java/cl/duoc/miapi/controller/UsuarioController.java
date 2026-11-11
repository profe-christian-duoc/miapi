package cl.duoc.miapi.controller;

import cl.duoc.miapi.model.Usuario;
import cl.duoc.miapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:5173/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // 1. GET: Listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // 2. GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        if (usuarioService.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    // 3. POST: Registrar / Crear
    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrar(usuario);
        return new ResponseEntity(nuevoUsuario,HttpStatus.CREATED);
    }

    // 4. PUT: Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizar(id, usuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // 5. DELETE: Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (usuarioService.borrar(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}