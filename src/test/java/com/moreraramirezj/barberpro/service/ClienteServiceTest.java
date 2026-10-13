package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Cliente;
import com.moreraramirezj.barberpro.persistence.InMemoryClienteRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {
    @Test
    void debeRegistrarClienteConTelefonoUnico() {
        ClienteService service = new ClienteService(new InMemoryClienteRepository());

        Cliente cliente = service.registrarCliente("Ana", "555-1010", "ana@barberpro.com", "Cliente frecuente");

        assertNotNull(cliente.getId());
        assertEquals(1, service.listarClientes().size());
    }

    @Test
    void debeRechazarClienteConTelefonoDuplicado() {
        ClienteService service = new ClienteService(new InMemoryClienteRepository());
        service.registrarCliente("Ana", "555-1010", "ana@barberpro.com", "");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.registrarCliente("Ana 2", "555-1010", "ana2@barberpro.com", "")
        );

        assertTrue(exception.getMessage().contains("teléfono"));
    }
}
