package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Cita;
import com.moreraramirezj.barberpro.model.EstadoCita;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarioService {
    public List<Cita> obtenerAgendaSemana(List<Cita> citas, LocalDate fechaReferencia) {
        LocalDate inicioSemana = fechaReferencia.with(java.time.DayOfWeek.MONDAY);
        LocalDate finSemana = inicioSemana.plusDays(6);

        return citas.stream()
                .filter(cita -> cita.getEstado() != EstadoCita.CANCELADA)
                .filter(cita -> !cita.getFechaHora().toLocalDate().isBefore(inicioSemana)
                        && !cita.getFechaHora().toLocalDate().isAfter(finSemana))
                .sorted(Comparator.comparing(Cita::getFechaHora))
                .collect(Collectors.toList());
    }

    public List<Cita> obtenerAgendaMes(List<Cita> citas, LocalDate fechaReferencia) {
        return citas.stream()
                .filter(cita -> cita.getEstado() != EstadoCita.CANCELADA)
                .filter(cita -> cita.getFechaHora().toLocalDate().getMonth() == fechaReferencia.getMonth())
                .sorted(Comparator.comparing(Cita::getFechaHora))
                .collect(Collectors.toList());
    }
}
