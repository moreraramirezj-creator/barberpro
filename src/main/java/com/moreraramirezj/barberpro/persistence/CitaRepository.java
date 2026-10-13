package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    void guardar(Cita cita);

    Optional<Cita> buscarPorId(String id);

    List<Cita> listar();
}
