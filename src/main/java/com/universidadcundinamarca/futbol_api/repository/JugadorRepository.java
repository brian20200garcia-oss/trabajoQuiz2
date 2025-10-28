package com.universidadcundinamarca.futbol_api.repository;

import com.universidadcundinamarca.futbol_api.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    // CONSULTA 1: Obtener todos los jugadores de un equipo específico [cite: 11]
    @Query(
            value = "SELECT j.* FROM jugador j WHERE j.id_equipo = :idEquipo",
            nativeQuery = true
    )
    List<Jugador> findJugadoresByEquipo(@Param("idEquipo") Integer idEquipo);
}