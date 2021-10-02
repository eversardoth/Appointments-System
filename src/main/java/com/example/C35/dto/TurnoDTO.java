package com.example.C35.dto;

import java.io.Serializable;
import java.util.Date;

public class TurnoDTO implements Serializable {

    private Long odontologoId;

    private Long pacienteId;

    private Date date;

    public TurnoDTO() {
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
