package com.miproyecto.registrolps.repository;

import com.miproyecto.registrolps.entity.Lectura;
import com.miproyecto.registrolps.entity.enums.Estado;
import com.miproyecto.registrolps.entity.enums.TipoLectura;
import com.miproyecto.registrolps.entity.enums.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LecturaRepository extends JpaRepository<Lectura, Long> {

    List<Lectura> findByTituloContainingIgnoreCase(String titulo);

    List<Lectura> findByAutorContainingIgnoreCase(String autor);

    List<Lectura> findByTipo(TipoLectura tipo);

    List<Lectura> findByEstado(Estado estado);

    List<Lectura> findByValoracion(Valoracion valoracion);
}