package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Cita;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCitaRepository implements CitaRepository {
    private final Map<String, Cita> citas = new ConcurrentHashMap<>();

    @Override
    public void guardar(Cita cita) {
        citas.put(cita.getId(), cita);
    }

    @Override
    public Optional<Cita> buscarPorId(String id) {
        return Optional.ofNullable(citas.get(id));
    }

    @Override
    public List<Cita> listar() {
        return new ArrayList<>(citas.values());
    }
}
