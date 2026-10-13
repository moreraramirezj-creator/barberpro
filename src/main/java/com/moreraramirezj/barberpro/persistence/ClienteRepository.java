package com.moreraramirezj.barberpro.persistence;

import com.moreraramirezj.barberpro.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    void guardar(Cliente cliente);

    Optional<Cliente> buscarPorId(String id);

    List<Cliente> listar();

    List<Cliente> buscarPorNombre(String texto);

    Optional<Cliente> buscarPorTelefono(String telefono);
}
