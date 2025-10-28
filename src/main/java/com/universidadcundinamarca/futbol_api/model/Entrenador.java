package com.universidadcundinamarca.futbol_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entrenador")
@Data
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrenador;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String especialidad;

    // FK a Equipo [cite: 35]
    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;
}