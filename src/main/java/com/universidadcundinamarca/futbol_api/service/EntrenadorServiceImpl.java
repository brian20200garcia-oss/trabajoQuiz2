package com.universidadcundinamarca.futbol_api.service;

import com.universidadcundinamarca.futbol_api.model.Entrenador;
import com.universidadcundinamarca.futbol_api.repository.EntrenadorRepository;
import com.universidadcundinamarca.futbol_api.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() { return entrenadorRepository.findAll(); }
    @Override
    public Optional<Entrenador> findById(Integer id) { return entrenadorRepository.findById(id); }
    @Override
    public Entrenador save(Entrenador entrenador) { return entrenadorRepository.save(entrenador); }
    @Override
    public void deleteById(Integer id) { entrenadorRepository.deleteById(id); }
}