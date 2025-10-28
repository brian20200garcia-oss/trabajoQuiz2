package com.universidadcundinamarca.futbol_api.controller;

import com.universidadcundinamarca.futbol_api.model.EstadisticaJugador;
import com.universidadcundinamarca.futbol_api.service.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaJugadorController {

    @Autowired
    private EstadisticaJugadorService estadisticaJugadorService;

    // --- CRUD BÁSICO ---

    @GetMapping
    public ResponseEntity<List<EstadisticaJugador>> getAllEstadisticas() {
        return ResponseEntity.ok(estadisticaJugadorService.findAll());
    }

    // ... Implementaciones de findById, create, update, delete (similar a EquipoController) ...

    // --- CONSULTA NATIVA 2 ---
    // Endpoint: GET http://localhost:8080/api/estadisticas/consulta/top-goleadores?minGoles=X

    @GetMapping("/consulta/top-goleadores")
    public ResponseEntity<List<Object[]>> getJugadoresByMinGoles(@RequestParam("minGoles") Integer minGoles) {
        List<Object[]> resultados = estadisticaJugadorService.findJugadoresByMinGoles(minGoles);
        return ResponseEntity.ok(resultados);
    }
}