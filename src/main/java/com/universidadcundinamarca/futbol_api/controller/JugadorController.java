package com.universidadcundinamarca.futbol_api.controller;

import com.universidadcundinamarca.futbol_api.model.Jugador;
import com.universidadcundinamarca.futbol_api.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // --- CRUD BÁSICO ---

    @GetMapping
    public ResponseEntity<List<Jugador>> getAllJugadores() {
        return ResponseEntity.ok(jugadorService.findAll());
    }

    // ... Implementaciones de findById, create, update, delete (similar a EquipoController) ...

    // --- CONSULTA NATIVA 1 ---
    // Endpoint: GET http://localhost:8080/api/jugadores/consulta/equipo/{idEquipo}

    @GetMapping("/consulta/equipo/{idEquipo}")
    public ResponseEntity<List<Jugador>> getJugadoresByEquipo(@PathVariable Integer idEquipo) {
        List<Jugador> jugadores = jugadorService.findJugadoresByEquipo(idEquipo);
        if (jugadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jugadores);
    }

    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        // Lógica para guardar el jugador usando el servicio
        Jugador nuevoJugador = jugadorService.save(jugador);
        return ResponseEntity.ok(nuevoJugador);
    }
}