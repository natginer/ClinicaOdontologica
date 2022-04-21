package com.example.clinica.services;
import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.dto.TurnoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoService {

    private ITurnoRepository turnoRepository;

    private PacienteService pacienteService;

    private OdontologoService odontologoService;

    @Autowired
    public TurnoService(ITurnoRepository iTurnoRepository, PacienteService pacienteService,
                        OdontologoService odontologoService) {
        this.turnoRepository = iTurnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    public TurnoDTO guardar(PostTurnoDTO postTurnoDTO){
        Paciente paciente = pacienteService.buscarDni(postTurnoDTO.getDni());
        Odontologo odontologo = odontologoService.getByMatricula(postTurnoDTO.getMatricula());
        Turno turno = new Turno(postTurnoDTO.getFechaTurno(), paciente, odontologo);
        Turno saveTurno =  turnoRepository.save(turno);
        return TurnoDTO.maptoTurnoDTO(saveTurno);
    }


    public List<TurnoDTO> buscarTodos(){
        return turnoRepository.findAll().stream()
                .map(TurnoDTO::maptoTurnoDTO)
                .collect(Collectors.toList());
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(id);
    }

    public TurnoDTO buscar(Integer id){
        return turnoRepository.findById(id)
                .map(TurnoDTO::maptoTurnoDTO)
                .orElseThrow(() -> new NotFoundException("Turno not found"));
    }

    public TurnoDTO actualizar(Turno t) {
        Turno turno =  turnoRepository.save(t);
        return TurnoDTO.maptoTurnoDTO(turno);
    }
}
