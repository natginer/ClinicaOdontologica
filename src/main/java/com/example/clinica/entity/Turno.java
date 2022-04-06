package com.example.clinica.entity;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    int id;
    private Date fecha;
    private Time hora;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="paciente_id", referencedColumnName = "id")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="odontologo_id", referencedColumnName = "id")
    private Odontologo odontologo;


    public Turno() {
    }

    public Turno(int id, Date fecha, Time hora, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Date fecha, Time hora, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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
                ", hora='" + hora + '\'' +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }
}