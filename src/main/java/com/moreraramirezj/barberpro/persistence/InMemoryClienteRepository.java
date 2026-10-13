package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryClienteRepository implements ClienteRepository {
    private final Map<String, Cliente> clientes = new ConcurrentHashMap<>();

    @Override
    public void guardar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return Optional.ofNullable(clientes.get(id));
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public List<Cliente> buscarPorNombre(String texto) {
        if (texto == null) {
            return new ArrayList<>();
        }
        return clientes.values().stream()
                .filter(cliente -> cliente.getNombre() != null && cliente.getNombre().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> buscarPorTelefono(String telefono) {
        if (telefono == null) {
            return Optional.empty();
        }
        return clientes.values().stream()
                .filter(cliente -> cliente.getTelefono() != null && cliente.getTelefono().equals(telefono))
                .findFirst();
    }
}
