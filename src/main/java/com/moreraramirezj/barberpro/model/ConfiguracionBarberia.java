package com.moreraramirezj.barberpro.model;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionBarberia {
    private final List<HorarioAtencion> horarios;

    public ConfiguracionBarberia() {
        this.horarios = new ArrayList<>();
    }

    public void agregarHorario(HorarioAtencion horario) {
        horarios.add(horario);
    }

    public List<HorarioAtencion> getHorarios() {
        return horarios;
    }
}
