package com.example.clinica.services;

import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.entity.Paciente;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.IDomicilioRepository;
import com.example.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IDomicilioRepository domicilioRepository;

        public PacienteService(){
        }

        public PacienteDTO guardar(Paciente p){
            Paciente paciente = pacienteRepository.save(p);
            return new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(), paciente.getDni(),paciente.getFechaIngreso(),paciente.getDomicilio());
        }

        public PacienteDTO buscar(int id) {
            Paciente paciente = pacienteRepository.getById(id);
            return new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(),
                    paciente.getDni(),paciente.getFechaIngreso(),paciente.getDomicilio());
            }

        public List<PacienteDTO> buscarTodos(){
            List<Paciente>pacientes = pacienteRepository.findAll();
            return pacientes.stream().map(paciente -> new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(),
                    paciente.getDni(),paciente.getFechaIngreso(),paciente.getDomicilio())).collect(Collectors.toList());
        }

        public void eliminar(int id){
            pacienteRepository.deleteById(id);
        }

        public PacienteDTO actualizar(Paciente p) {
            Paciente paciente =  pacienteRepository.save(p);
            return new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(), paciente.getDni(),paciente.getFechaIngreso(),paciente.getDomicilio());
    }


    public Paciente buscarDni (int dni){
        Optional<Paciente> optPaciente = pacienteRepository.getByDni(dni);
        return optPaciente.orElseThrow(() -> new NotFoundException("Paciente not found"));
    }


    }
