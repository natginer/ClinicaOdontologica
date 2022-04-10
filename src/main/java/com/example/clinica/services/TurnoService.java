package com.example.clinica.services;
import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.dto.TurnoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.ITurnoRepository;
import com.mashape.unirest.http.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    public TurnoService() {}

    public TurnoDTO guardar(PostTurnoDTO postTurnoDTO){
        Paciente paciente = pacienteService.buscarDni(postTurnoDTO.getDni());
        Odontologo odontologo = odontologoService.getByMatricula(postTurnoDTO);
        Turno turno = new Turno(postTurnoDTO.getFechaTurno(), paciente, odontologo);
        Turno saveTurno =  turnoRepository.save(turno);
        PacienteDTO pacienteDTO =  new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(), paciente.getDni(),paciente.getFechaIngreso(),paciente.getDomicilio());
        OdontologoDTO odontologoDTO = new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(), odontologo.getMatricula());
        return new TurnoDTO(saveTurno.getId(), saveTurno.getFecha(), pacienteDTO, odontologoDTO);
    }

    public List<TurnoDTO> buscarTodos(){
        return turnoRepository.findAll().stream()
                .map(t ->new TurnoDTO(t.getId(), t.getFecha(), new PacienteDTO(t.getPaciente().getId(),
                        t.getPaciente().getNombre(),t.getPaciente().getApellido(),
                        t.getPaciente().getDni(),t.getPaciente().getFechaIngreso(),t.getPaciente().getDomicilio())
                        ,new OdontologoDTO(t.getOdontologo().getId(), t.getOdontologo().getNombre(),
                        t.getOdontologo().getApellido(), t.getOdontologo().getMatricula())))
                .collect(Collectors.toList());
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(id);
    }

    public TurnoDTO buscar(Integer id){
        return turnoRepository.findById(id)
                .map(t ->new TurnoDTO(t.getId(), t.getFecha(), new PacienteDTO(t.getPaciente().getId(),
                        t.getPaciente().getNombre(),t.getPaciente().getApellido(),
                        t.getPaciente().getDni(),t.getPaciente().getFechaIngreso(),t.getPaciente().getDomicilio()), new OdontologoDTO(t.getOdontologo().getId(), t.getOdontologo().getNombre(),
                        t.getOdontologo().getApellido(), t.getOdontologo().getMatricula())))
                .orElseThrow(() -> new NotFoundException("Turno not found"));
    }

    public TurnoDTO actualizar (Turno turno){
        Turno saveTurno =  turnoRepository.save(turno);
        PacienteDTO pacienteDTO =  new PacienteDTO(saveTurno.getPaciente().getId(),saveTurno.getPaciente().getNombre(),saveTurno.getPaciente().getApellido(), saveTurno.getPaciente().getDni(),saveTurno.getPaciente().getFechaIngreso(),saveTurno.getPaciente().getDomicilio());
        OdontologoDTO odontologoDTO = new OdontologoDTO(saveTurno.getOdontologo().getId(), saveTurno.getOdontologo().getNombre(),saveTurno.getOdontologo().getApellido(), saveTurno.getOdontologo().getMatricula());

        return new TurnoDTO(saveTurno.getId(), saveTurno.getFecha(),pacienteDTO, odontologoDTO);

    }
}