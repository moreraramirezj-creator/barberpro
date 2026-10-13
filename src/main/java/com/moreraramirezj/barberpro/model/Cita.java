package com.moreraramirezj.barberpro.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
    private final String id;
    private String clienteId;
    private String servicioId;
    private LocalDateTime fechaHora;
    private EstadoCita estado;

    public Cita(String id, String clienteId, String servicioId, LocalDateTime fechaHora, EstadoCita estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita)) return false;
        Cita cita = (Cita) o;
        return Objects.equals(id, cita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
