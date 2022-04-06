package com.example.clinica.repository;

import com.example.clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRespository extends JpaRepository<Odontologo, Integer> {
}
