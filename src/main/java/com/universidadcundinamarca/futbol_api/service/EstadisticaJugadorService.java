package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.EstadisticaJugador;
import java.util.List;
import java.util.Optional;

public interface EstadisticaJugadorService {
    // CRUD
    List<EstadisticaJugador> findAll();
    Optional<EstadisticaJugador> findById(Integer id);
    EstadisticaJugador save(EstadisticaJugador estadisticaJugador);
    void deleteById(Integer id);

    // CONSULTA 2: Jugadores con más de X goles
    List<Object[]> findJugadoresByMinGoles(Integer minGoles);
}