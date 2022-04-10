package com.example.clinica.dto;

import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class TurnoDTO {
    int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fecha;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

    public TurnoDTO(int id, Date fecha, PacienteDTO paciente, OdontologoDTO odontologo) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }
}
