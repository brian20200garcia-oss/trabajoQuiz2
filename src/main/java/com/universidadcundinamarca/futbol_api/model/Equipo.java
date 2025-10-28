package com.universidadcundinamarca.futbol_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "equipo")
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String ciudad;

    private LocalDate fundacion;

    // Relaciones (para la base del CRUD)
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Entrenador> entrenadores;

    // Los partidos se gestionan en la entidad Partido
}