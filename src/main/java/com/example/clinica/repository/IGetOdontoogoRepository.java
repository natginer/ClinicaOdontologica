package com.example.clinica.repository;

import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGetOdontoogoRepository extends JpaRepository<Odontologo, PostTurnoDTO> {

    @Query("SELECT o FROM Odontologo o where o.nombre = :#{#turno.nombre} and o.apellido = :#{#turno.apellido}")
    Optional<Odontologo> getByNombreApellido(@Param("turno") PostTurnoDTO postTurnoDTO);

    @Query("SELECT o FROM Odontologo o where o.matricula = :#{#turno.matricula} ")
    Optional<Odontologo> getByMatricula(@Param("turno") PostTurnoDTO postTurnoDTO);

}