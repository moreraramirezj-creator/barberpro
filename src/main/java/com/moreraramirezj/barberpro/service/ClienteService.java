package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Cliente;
import com.moreraramirezj.barberpro.persistence.ClienteRepository;

import java.util.List;
import java.util.UUID;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente registrarCliente(String nombre, String telefono, String correo, String observaciones) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono del cliente es obligatorio.");
        }

        if (clienteRepository.buscarPorTelefono(telefono).isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con ese teléfono.");
        }

        Cliente cliente = new Cliente(UUID.randomUUID().toString(), nombre, telefono, correo, observaciones);
        clienteRepository.guardar(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listar();
    }

    public List<Cliente> buscarClientes(String texto) {
        if (texto == null || texto.isBlank()) {
            return clienteRepository.listar();
        }
        return clienteRepository.buscarPorNombre(texto);
    }
}
