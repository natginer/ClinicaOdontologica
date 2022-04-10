package com.example.clinica.repository;

import com.example.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p where p.dni =?1")
    Optional<Paciente> getByDni (int dni);
}
