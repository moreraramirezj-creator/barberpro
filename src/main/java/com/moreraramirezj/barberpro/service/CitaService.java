package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Cita;
import com.moreraramirezj.barberpro.model.EstadoCita;
import com.moreraramirezj.barberpro.model.Servicio;
import com.moreraramirezj.barberpro.persistence.CitaRepository;
import com.moreraramirezj.barberpro.persistence.ServicioRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CitaService {
    private final CitaRepository citaRepository;
    private final ServicioRepository servicioRepository;

    public CitaService(CitaRepository citaRepository, ServicioRepository servicioRepository) {
        this.citaRepository = citaRepository;
        this.servicioRepository = servicioRepository;
    }

    public Cita agendarCita(String clienteId, String servicioId, LocalDateTime fechaHora) {
        if (clienteId == null || clienteId.isBlank()) {
            throw new IllegalArgumentException("Debe indicar el cliente.");
        }
        if (servicioId == null || servicioId.isBlank()) {
            throw new IllegalArgumentException("Debe indicar el servicio.");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias.");
        }

        Servicio servicio = servicioRepository.buscarPorId(servicioId)
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado."));

        LocalDateTime finCita = fechaHora.plusMinutes(servicio.getDuracionMinutos());

        boolean conflicto = citaRepository.listar().stream()
                .filter(cita -> cita.getEstado() != EstadoCita.CANCELADA)
                .anyMatch(cita -> {
                    Servicio servicioExistente = servicioRepository.buscarPorId(cita.getServicioId())
                            .orElseThrow(() -> new IllegalArgumentException("Servicio de la cita no encontrado."));
                    LocalDateTime finExistente = cita.getFechaHora().plusMinutes(servicioExistente.getDuracionMinutos());
                    return !(finCita.isBefore(cita.getFechaHora()) || fechaHora.isAfter(finExistente));
                });

        if (conflicto) {
            throw new IllegalArgumentException("La cita genera un conflicto de horario.");
        }

        Cita cita = new Cita(UUID.randomUUID().toString(), clienteId, servicioId, fechaHora, EstadoCita.PENDIENTE);
        citaRepository.guardar(cita);
        return cita;
    }

    public List<Cita> listarCitas() {
        return citaRepository.listar();
    }
}
