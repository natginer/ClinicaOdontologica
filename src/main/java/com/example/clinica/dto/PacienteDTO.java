package com.example.clinica.dto;

import com.example.clinica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


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
}
