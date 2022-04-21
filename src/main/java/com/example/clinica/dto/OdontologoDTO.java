package com.example.clinica.dto;


import com.example.clinica.entity.Odontologo;

import java.util.Objects;

public class OdontologoDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String matricula;

    public OdontologoDTO() {

    }

    public OdontologoDTO(int id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public OdontologoDTO(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public static OdontologoDTO mapToOdontologoDTO(Odontologo odontologo){
        return new OdontologoDTO(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido(),
                odontologo.getMatricula());

    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OdontologoDTO that = (OdontologoDTO) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, matricula);
    }
}
