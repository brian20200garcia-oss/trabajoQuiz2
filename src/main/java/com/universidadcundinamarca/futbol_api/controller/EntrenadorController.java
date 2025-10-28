package com.universidadcundinamarca.futbol_api.controller;

import com.universidadcundinamarca.futbol_api.model.Entrenador;
import com.universidadcundinamarca.futbol_api.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // --- CRUD COMPLETO ---

    @GetMapping
    public ResponseEntity<List<Entrenador>> getAllEntrenadores() {
        return ResponseEntity.ok(entrenadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Integer id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entrenador> createEntrenador(@RequestBody Entrenador entrenador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenadorService.save(entrenador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Integer id, @RequestBody Entrenador entrenadorDetails) {
        return entrenadorService.findById(id).map(entrenador -> {
            entrenador.setNombre(entrenadorDetails.getNombre());
            entrenador.setEspecialidad(entrenadorDetails.getEspecialidad());
            entrenador.setEquipo(entrenadorDetails.getEquipo());
            return ResponseEntity.ok(entrenadorService.save(entrenador));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Integer id) {
        entrenadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}