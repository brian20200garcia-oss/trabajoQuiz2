package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Jugador;
import java.util.List;
import java.util.Optional;

public interface JugadorService {
    // Métodos CRUD que deben ser implementados por JugadorServiceImpl
    List<Jugador> findAll();
    Optional<Jugador> findById(Integer id);
    Jugador save(Jugador jugador);
    void deleteById(Integer id); // <-- Este es el método que falta

    // Consulta nativa 1
    List<Jugador> findJugadoresByEquipo(Integer idEquipo);
}