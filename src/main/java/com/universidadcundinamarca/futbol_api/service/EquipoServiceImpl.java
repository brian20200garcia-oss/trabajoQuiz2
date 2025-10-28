package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Equipo;
import com.universidadcundinamarca.futbol_api.repository.EquipoRepository;
import com.universidadcundinamarca.futbol_api.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<Equipo> findAll() { return equipoRepository.findAll(); }
    @Override
    public Optional<Equipo> findById(Integer id) { return equipoRepository.findById(id); }
    @Override
    public Equipo save(Equipo equipo) { return equipoRepository.save(equipo); }
    @Override
    public void deleteById(Integer id) { equipoRepository.deleteById(id); }

    // Implementación de la CONSULTA 3
    @Override
    public List<Object[]> countGolesTotalesByEquipo() {
        return equipoRepository.countGolesTotalesByEquipo();
    }
}