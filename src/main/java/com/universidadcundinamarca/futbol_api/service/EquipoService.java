package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Equipo;
import java.util.List;
import java.util.Optional;

public interface EquipoService {
    // CRUD
    List<Equipo> findAll();
    Optional<Equipo> findById(Integer id);
    Equipo save(Equipo equipo);
    void deleteById(Integer id);

    // CONSULTA 3: Total de goles por equipo
    List<Object[]> countGolesTotalesByEquipo();
}