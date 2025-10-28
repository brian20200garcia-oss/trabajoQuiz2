package com.universidadcundinamarca.futbol_api.repository;

import com.universidadcundinamarca.futbol_api.model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Integer> {

    // CONSULTA 2: Obtener los jugadores que han marcado más de X goles [cite: 12]
    @Query(
            value = "SELECT j.nombre, SUM(ej.goles) as total_goles " +
                    "FROM estadisticas_jugador ej JOIN jugador j ON ej.id_jugador = j.id_jugador " +
                    "GROUP BY j.id_jugador, j.nombre HAVING SUM(ej.goles) > :minGoles " +
                    "ORDER BY total_goles DESC",
            nativeQuery = true
    )
    List<Object[]> findJugadoresByMinGoles(@Param("minGoles") Integer minGoles);
}