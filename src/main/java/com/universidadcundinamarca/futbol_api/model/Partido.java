package com.universidadcundinamarca.futbol_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partido")
@Data
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;

    private LocalDate fecha;

    @Column(length = 100)
    private String estadio;

    private Integer golesLocal;
    private Integer golesVisita;

    // FK a Equipo (Local) [cite: 39]
    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    // FK a Equipo (Visitante) [cite: 39]
    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private Equipo equipoVisitante;

    // Relación con estadísticas [cite: 61]
    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<EstadisticaJugador> estadisticas;
}