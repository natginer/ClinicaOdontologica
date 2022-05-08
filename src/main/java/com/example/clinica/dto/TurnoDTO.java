package com.example.clinica.dto;

import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.Objects;

public class TurnoDTO {
    private int id;
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

    public static TurnoDTO maptoTurnoDTO(Turno turno){
       return new TurnoDTO(turno.getId(), turno.getFecha(), PacienteDTO.mapToPacienteDTO(turno.getPaciente()),
                OdontologoDTO.mapToOdontologoDTO(turno.getOdontologo()));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnoDTO turnoDTO = (TurnoDTO) o;
        return id == turnoDTO.id && Objects.equals(paciente, turnoDTO.paciente) && Objects.equals(odontologo, turnoDTO.odontologo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paciente, odontologo);
    }

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }
}
