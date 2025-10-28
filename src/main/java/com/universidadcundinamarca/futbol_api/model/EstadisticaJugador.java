package com.universidadcundinamarca.futbol_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estadisticas_jugador")
@Data
public class EstadisticaJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadistica;

    private Integer minutosJugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;

    // FK a Jugador [cite: 41]
    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    // FK a Partido [cite: 41]
    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;
}