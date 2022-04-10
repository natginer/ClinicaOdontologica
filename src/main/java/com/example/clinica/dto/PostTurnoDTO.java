package com.example.clinica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostTurnoDTO {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaTurno;
    private int dni;
    private String nombre;
    private String apellido;
    private String matricula;

    public PostTurnoDTO(Date fecha, int dni, String nombre, String apellido, String matricula) {
        this.fechaTurno = fecha;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }
}
