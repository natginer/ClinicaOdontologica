package com.example.clinica.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id", referencedColumnName = "id",nullable = false)
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(int id, Date fecha, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Date fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id+
                ", fecha=" + fecha +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }

}