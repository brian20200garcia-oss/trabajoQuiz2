package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Entrenador;
import java.util.List;
import java.util.Optional;

public interface EntrenadorService {
    // CRUD
    List<Entrenador> findAll();
    Optional<Entrenador> findById(Integer id);
    Entrenador save(Entrenador entrenador);
    void deleteById(Integer id);
}