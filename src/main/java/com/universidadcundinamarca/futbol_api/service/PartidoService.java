package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Partido;
import java.util.List;
import java.util.Optional;

public interface PartidoService {
    // CRUD
    List<Partido> findAll();
    Optional<Partido> findById(Integer id);
    Partido save(Partido partido);
    void deleteById(Integer id);

    // CONSULTA 4: Resultados de partidos con nombres
    List<Object[]> findResultadosPartidosConNombres();
}