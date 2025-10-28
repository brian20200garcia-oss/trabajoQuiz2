package com.universidadcundinamarca.futbol_api.repository;

import com.universidadcundinamarca.futbol_api.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    // CONSULTA 4: Obtener los resultados de todos los partidos indicando los nombres de los equipos [cite: 14]
    @Query(
            value = "SELECT p.fecha, el.nombre AS equipo_local, p.goles_local, ev.nombre AS equipo_visitante, p.goles_visita " +
                    "FROM partido p " +
                    "JOIN equipo el ON p.equipo_local = el.id_equipo " +
                    "JOIN equipo ev ON p.equipo_visita = ev.id_equipo " +
                    "ORDER BY p.fecha DESC",
            nativeQuery = true
    )
    List<Object[]> findResultadosPartidosConNombres();
}