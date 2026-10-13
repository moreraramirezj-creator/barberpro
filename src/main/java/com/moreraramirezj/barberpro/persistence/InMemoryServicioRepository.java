package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryServicioRepository implements ServicioRepository {
    private final Map<String, Servicio> servicios = new ConcurrentHashMap<>();

    @Override
    public void guardar(Servicio servicio) {
        servicios.put(servicio.getId(), servicio);
    }

    @Override
    public Optional<Servicio> buscarPorId(String id) {
        return Optional.ofNullable(servicios.get(id));
    }

    @Override
    public List<Servicio> listar() {
        return new ArrayList<>(servicios.values());
    }

    @Override
    public Optional<Servicio> buscarPorNombre(String nombre) {
        if (nombre == null) {
            return Optional.empty();
        }
        return servicios.values().stream()
                .filter(servicio -> servicio.getNombre() != null && servicio.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
