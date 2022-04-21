package com.example.clinica.dto;

import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.Objects;


public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private int dni;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaIngreso;
    private Domicilio domicilio;

    public PacienteDTO(Integer id, String nombre, String apellido, int dni, Date fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public PacienteDTO(String nombre, String apellido, int dni, Date fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public static PacienteDTO mapToPacienteDTO(Paciente paciente){
        return new PacienteDTO(paciente.getId(), paciente.getNombre(), paciente.getApellido(),
                paciente.getDni(),paciente.getFechaIngreso(), paciente.getDomicilio() );
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteDTO that = (PacienteDTO) o;
        return dni == that.dni && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(domicilio, that.domicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, domicilio);
    }
}
