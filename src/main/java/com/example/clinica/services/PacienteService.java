package com.example.clinica.services;

import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.entity.Paciente;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

        public PacienteDTO guardar(Paciente p){
            Paciente paciente = pacienteRepository.save(p);
            return PacienteDTO.mapToPacienteDTO(paciente);
        }

        public PacienteDTO buscar(int id) {
            Paciente paciente = pacienteRepository.getById(id);
            return PacienteDTO.mapToPacienteDTO(paciente);
            }

        public List<PacienteDTO> buscarTodos(){
            List<Paciente>pacientes = pacienteRepository.findAll();
            return pacientes.stream().map(PacienteDTO::mapToPacienteDTO).collect(Collectors.toList());
        }

        public void eliminar(int id){
            pacienteRepository.deleteById(id);
        }

        public PacienteDTO actualizar(Paciente p) {
            Paciente paciente =  pacienteRepository.save(p);
            return PacienteDTO.mapToPacienteDTO(paciente);
    }


    public Paciente buscarDni (int dni){
        Optional<Paciente> optPaciente = pacienteRepository.getByDni(dni);
        return optPaciente.orElseThrow(() -> new NotFoundException("Paciente not found"));
    }

    }
