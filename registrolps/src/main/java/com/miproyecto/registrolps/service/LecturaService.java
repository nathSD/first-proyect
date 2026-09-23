package com.miproyecto.registrolps.service;

import com.miproyecto.registrolps.entity.Lectura;
import com.miproyecto.registrolps.entity.enums.Estado;
import com.miproyecto.registrolps.entity.enums.TipoLectura;
import com.miproyecto.registrolps.entity.enums.Valoracion;
import com.miproyecto.registrolps.repository.LecturaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LecturaService {

    private final LecturaRepository lecturaRepository;

    LecturaService(LecturaRepository lecturaRepository) {
        this.lecturaRepository = lecturaRepository;
    }

    public Lectura crearLectura(Lectura lectura) {
        validarReglaValoracion(lectura);
        return lecturaRepository.save(lectura);
    }

    private void validarReglaValoracion(Lectura lectura) {
        boolean esFinalizadoOAbandonado = lectura.getEstado() == Estado.Finalizado 
                                       || lectura.getEstado() == Estado.Abandonado;
        if (!esFinalizadoOAbandonado) {
            lectura.setValoracion(null);
        }
    }

    public List<Lectura> obtenerTodas() {
    return lecturaRepository.findAll();
    }

    public Lectura obtenerPorId(Long id) {
        return lecturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la lectura con el ID: " + id));
    }

    public List<Lectura> buscarPorFiltro(String filtro, String valor) {
        if (valor == null || valor.isBlank()) {
            return lecturaRepository.findAll();
        }

        switch (filtro.toLowerCase()) {
            case "autor":
                return lecturaRepository.findByAutorContainingIgnoreCase(valor);
            case "tipo":
                return lecturaRepository.findByTipo(TipoLectura.valueOf(valor));
            case "estado":
                return lecturaRepository.findByEstado(Estado.valueOf(valor));
            case "valoracion":
                return lecturaRepository.findByValoracion(Valoracion.valueOf(valor));
            case "titulo":
            default:
                return lecturaRepository.findByTituloContainingIgnoreCase(valor);
        }
    }

    public Lectura actualizarLectura(Long id, Lectura lecturaDetalles) {
    Lectura lecturaExistente = obtenerPorId(id);

    lecturaExistente.setTitulo(lecturaDetalles.getTitulo());
    lecturaExistente.setAutor(lecturaDetalles.getAutor());
    lecturaExistente.setTipo(lecturaDetalles.getTipo());
    lecturaExistente.setEstado(lecturaDetalles.getEstado());
    lecturaExistente.setNumeroVolumenes(lecturaDetalles.getNumeroVolumenes());
    lecturaExistente.setNumeroCapitulos(lecturaDetalles.getNumeroCapitulos());
    lecturaExistente.setComentario(lecturaDetalles.getComentario());

    lecturaExistente.setValoracion(lecturaDetalles.getValoracion());
    validarReglaValoracion(lecturaExistente);

    return lecturaRepository.save(lecturaExistente);
    }

    public void eliminarLectura(Long id) {
    if (!lecturaRepository.existsById(id)) {
        throw new RuntimeException("No existe la lectura con el ID: " + id);
    }
    lecturaRepository.deleteById(id);
    }
}
