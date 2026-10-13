package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Servicio;
import com.moreraramirezj.barberpro.persistence.ServicioRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio registrarServicio(String nombre, Integer duracionMinutos, BigDecimal precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del servicio es obligatorio.");
        }
        if (duracionMinutos == null || duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }

        if (servicioRepository.buscarPorNombre(nombre).isPresent()) {
            throw new IllegalArgumentException("Ya existe un servicio con ese nombre.");
        }

        Servicio servicio = new Servicio(UUID.randomUUID().toString(), nombre, duracionMinutos, precio);
        servicioRepository.guardar(servicio);
        return servicio;
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.listar();
    }
}
