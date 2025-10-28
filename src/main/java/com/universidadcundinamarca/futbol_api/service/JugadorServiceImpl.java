package com.universidadcundinamarca.futbol_api.service;
// Nota: Las clases de implementación (Impl) suelen ir en un subpaquete 'impl'.

import com.universidadcundinamarca.futbol_api.model.Jugador;
import com.universidadcundinamarca.futbol_api.repository.JugadorRepository;
import com.universidadcundinamarca.futbol_api.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // --- Implementaciones CRUD COMPLETAS ---

    @Override
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Override
    public Optional<Jugador> findById(Integer id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // MÉTODO FALTANTE CORREGIDO
    @Override
    public void deleteById(Integer id) {
        jugadorRepository.deleteById(id);
    }
    // ---------------------------------------

    // CONSULTA 1: Implementación de la consulta nativa
    @Override
    public List<Jugador> findJugadoresByEquipo(Integer idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }
}