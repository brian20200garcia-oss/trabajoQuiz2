package com.universidadcundinamarca.futbol_api.repository;

import com.universidadcundinamarca.futbol_api.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    // CONSULTA 3: Obtener el número total de goles marcados por un equipo [cite: 13]
    @Query(
            value = "SELECT e.nombre, SUM(CASE " +
                    "WHEN p.equipo_local = e.id_equipo THEN p.goles_local " +
                    "WHEN p.equipo_visita = e.id_equipo THEN p.goles_visita " +
                    "ELSE 0 END) AS total_goles_anotados " +
                    "FROM equipo e " +
                    "JOIN partido p ON e.id_equipo = p.equipo_local OR e.id_equipo = p.equipo_visita " +
                    "GROUP BY e.id_equipo, e.nombre " +
                    "ORDER BY total_goles_anotados DESC",
            nativeQuery = true
    )
    List<Object[]> countGolesTotalesByEquipo();
}