package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.EstadisticaJugador;
import com.universidadcundinamarca.futbol_api.repository.EstadisticaJugadorRepository;
import com.universidadcundinamarca.futbol_api.service.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorServiceImpl implements EstadisticaJugadorService {

    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    @Override
    public List<EstadisticaJugador> findAll() { return estadisticaJugadorRepository.findAll(); }
    @Override
    public Optional<EstadisticaJugador> findById(Integer id) { return estadisticaJugadorRepository.findById(id); }
    @Override
    public EstadisticaJugador save(EstadisticaJugador estadisticaJugador) { return estadisticaJugadorRepository.save(estadisticaJugador); }
    @Override
    public void deleteById(Integer id) { estadisticaJugadorRepository.deleteById(id); }

    // Implementación de la CONSULTA 2
    @Override
    public List<Object[]> findJugadoresByMinGoles(Integer minGoles) {
        return estadisticaJugadorRepository.findJugadoresByMinGoles(minGoles);
    }
}