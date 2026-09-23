package com.miproyecto.registrolps.controller;

import com.miproyecto.registrolps.entity.Lectura;
import com.miproyecto.registrolps.service.LecturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecturas")
@CrossOrigin(origins = "*") // Permite la conexión desde el Frontend
public class LecturaController {

    private final LecturaService lecturaService;

    public LecturaController(LecturaService lecturaService) {
        this.lecturaService = lecturaService;
    }

    @GetMapping
    public ResponseEntity<List<Lectura>> obtenerTodas() {
        return ResponseEntity.ok(lecturaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lectura> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lecturaService.obtenerPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Lectura>> buscarPorFiltro(
            @RequestParam(defaultValue = "titulo") String filtro,
            @RequestParam(required = false) String valor) {
        return ResponseEntity.ok(lecturaService.buscarPorFiltro(filtro, valor));
    }

    @PostMapping
    public ResponseEntity<Lectura> crearLectura(@RequestBody Lectura lectura) {
        Lectura nuevaLectura = lecturaService.crearLectura(lectura);
        return new ResponseEntity<>(nuevaLectura, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lectura> actualizarLectura(@PathVariable Long id, @RequestBody Lectura lectura) {
        Lectura lecturaActualizada = lecturaService.actualizarLectura(id, lectura);
        return ResponseEntity.ok(lecturaActualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLectura(@PathVariable Long id) {
        lecturaService.eliminarLectura(id);
        return ResponseEntity.noContent().build();
    }
}