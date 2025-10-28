package com.universidadcundinamarca.futbol_api.controller;

import com.universidadcundinamarca.futbol_api.model.Equipo;
import com.universidadcundinamarca.futbol_api.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // --- CRUD BÁSICO ---

    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        return ResponseEntity.ok(equipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Integer id) {
        return equipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(equipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Integer id, @RequestBody Equipo equipoDetails) {
        return equipoService.findById(id).map(equipo -> {
            equipo.setNombre(equipoDetails.getNombre());
            equipo.setCiudad(equipoDetails.getCiudad());
            equipo.setFundacion(equipoDetails.getFundacion());
            return ResponseEntity.ok(equipoService.save(equipo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Integer id) {
        equipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- CONSULTA NATIVA 3 ---
    // Endpoint: GET http://localhost:8080/api/equipos/consulta/goles-totales

    @GetMapping("/consulta/goles-totales")
    public ResponseEntity<List<Object[]>> countGolesTotalesByEquipo() {
        List<Object[]> resultados = equipoService.countGolesTotalesByEquipo();
        return ResponseEntity.ok(resultados);
    }
}