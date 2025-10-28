package com.universidadcundinamarca.futbol_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jugador")
@Data
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 50)
    private String posicion;

    private Integer dorsal;
    private LocalDate fechaNac;

    @Column(length = 100)
    private String nacionalidad;

    // FK a Equipo [cite: 33]
    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    // Relación con estadísticas [cite: 57]
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<EstadisticaJugador> estadisticas;
}