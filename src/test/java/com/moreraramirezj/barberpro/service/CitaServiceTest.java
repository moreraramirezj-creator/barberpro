package com.moreraramirezj.barberpro.service;

import com.moreraramirezj.barberpro.model.Cita;
import com.moreraramirezj.barberpro.model.EstadoCita;
import com.moreraramirezj.barberpro.model.Servicio;
import com.moreraramirezj.barberpro.persistence.InMemoryCitaRepository;
import com.moreraramirezj.barberpro.persistence.InMemoryServicioRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaServiceTest {
    @Test
    void debeCrearCitaSinConflicto() {
        InMemoryServicioRepository servicioRepository = new InMemoryServicioRepository();
        Servicio servicio = new Servicio("svc-1", "Corte", 30, BigDecimal.valueOf(200));
        servicioRepository.guardar(servicio);

        CitaService service = new CitaService(new InMemoryCitaRepository(), servicioRepository);
        LocalDateTime fechaHora = LocalDateTime.of(2026, 10, 15, 10, 0);

        Cita cita = service.agendarCita("cliente-1", "svc-1", fechaHora);

        assertNotNull(cita.getId());
        assertEquals(EstadoCita.PENDIENTE, cita.getEstado());
    }

    @Test
    void debeRechazarCitaConConflictoDeHorario() {
        InMemoryServicioRepository servicioRepository = new InMemoryServicioRepository();
        Servicio servicio = new Servicio("svc-1", "Corte", 60, BigDecimal.valueOf(200));
        servicioRepository.guardar(servicio);

        InMemoryCitaRepository citaRepository = new InMemoryCitaRepository();
        CitaService service = new CitaService(citaRepository, servicioRepository);

        LocalDateTime fechaHora = LocalDateTime.of(2026, 10, 15, 10, 0);
        citaRepository.guardar(new Cita("cita-1", "cliente-1", "svc-1", fechaHora, EstadoCita.PENDIENTE));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.agendarCita("cliente-2", "svc-1", fechaHora.plusMinutes(30))
        );

        assertTrue(exception.getMessage().contains("conflicto"));
    }
}
