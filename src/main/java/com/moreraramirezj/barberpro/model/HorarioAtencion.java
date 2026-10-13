package com.moreraramirezj.barberpro.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioAtencion {
    private DayOfWeek dia;
    private LocalTime horaApertura;
    private LocalTime horaCierre;

    public HorarioAtencion(DayOfWeek dia, LocalTime horaApertura, LocalTime horaCierre) {
        this.dia = dia;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }
}
