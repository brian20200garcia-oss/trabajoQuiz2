package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Partido;
import com.universidadcundinamarca.futbol_api.repository.PartidoRepository;
import com.universidadcundinamarca.futbol_api.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public List<Partido> findAll() { return partidoRepository.findAll(); }
    @Override
    public Optional<Partido> findById(Integer id) { return partidoRepository.findById(id); }
    @Override
    public Partido save(Partido partido) { return partidoRepository.save(partido); }
    @Override
    public void deleteById(Integer id) { partidoRepository.deleteById(id); }

    // Implementación de la CONSULTA 4
    @Override
    public List<Object[]> findResultadosPartidosConNombres() {
        return partidoRepository.findResultadosPartidosConNombres();
    }
}