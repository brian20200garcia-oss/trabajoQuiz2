package com.universidadcundinamarca.futbol_api.controller;

import com.universidadcundinamarca.futbol_api.model.Partido;
import com.universidadcundinamarca.futbol_api.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    // --- CRUD BÁSICO ---

    @GetMapping
    public ResponseEntity<List<Partido>> getAllPartidos() {
        return ResponseEntity.ok(partidoService.findAll());
    }

    // ... Implementaciones de findById, create, update, delete (similar a EquipoController) ...

    // --- CONSULTA NATIVA 4 ---
    // Endpoint: GET http://localhost:8080/api/partidos/consulta/resultados

    @GetMapping("/consulta/resultados")
    public ResponseEntity<List<Object[]>> getResultadosPartidos() {
        List<Object[]> resultados = partidoService.findResultadosPartidosConNombres();
        return ResponseEntity.ok(resultados);
    }

    @PostMapping // ¡Esta línea es la clave! Acepta el POST en /api/partidos
    public ResponseEntity<Partido> crearPartido(@RequestBody Partido partido) {
        // Llama al servicio para guardar el objeto Partido
        Partido nuevoPartido = partidoService.save(partido);
        return ResponseEntity.ok(nuevoPartido);
    }
}