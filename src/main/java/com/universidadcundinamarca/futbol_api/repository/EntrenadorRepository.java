package com.universidadcundinamarca.futbol_api.repository;

import com.universidadcundinamarca.futbol_api.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
    // CRUD base heredado
    // No necesita consultas nativas adicionales para el quiz
}