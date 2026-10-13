package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioRepository {
    void guardar(Servicio servicio);

    Optional<Servicio> buscarPorId(String id);

    List<Servicio> listar();

    Optional<Servicio> buscarPorNombre(String nombre);
}
