package com.miproyecto.registrolps.controller;

import com.miproyecto.registrolps.entity.Usuario;
import com.miproyecto.registrolps.entity.enums.TipoUsuario;
import com.miproyecto.registrolps.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("usuario");
        String password = credenciales.get("ctrs");
        String tipoTexto = credenciales.get("tipo");

        if (usuario == null || password == null || tipoTexto == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "Usuario, contraseña y tipo son obligatorios"));
        }

        TipoUsuario tipo;
        try {
            tipo = TipoUsuario.valueOf(tipoTexto);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "El tipo de usuario no es válido"));
        }

        Optional<Usuario> user = usuarioService.login(usuario, password, tipo);

        if (user.isPresent()) {
            Usuario u = user.get();
            u.setPassword(null);
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", "Usuario o contraseña incorrectos"));
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getTipo() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "Usuario, contraseña y tipo son obligatorios"));
        }

        if (usuarioService.existePorUsuario(usuario.getUsuario())) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "El nombre de usuario ya existe"));
        }

        Usuario nuevo = usuarioService.registrar(usuario);
        nuevo.setPassword(null);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
}