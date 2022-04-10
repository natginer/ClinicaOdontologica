package com.example.clinica.repository;

import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRespository extends JpaRepository<Odontologo, Integer> {
}
