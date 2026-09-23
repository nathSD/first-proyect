package com.miproyecto.registrolps.entity;

import com.miproyecto.registrolps.entity.enums.Estado;
import com.miproyecto.registrolps.entity.enums.TipoLectura;
import com.miproyecto.registrolps.entity.enums.Valoracion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lecturas")
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    private String autor;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoLectura tipo;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Valoracion valoracion;
    
    private Integer numeroVolumenes;

    private Integer numeroCapitulos;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}

//Id, titulo, autor, tipo, estado, valoracion, numeroVolumenes, numeroCapitulos, comentario.