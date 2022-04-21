package com.example.clinica;

import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.dto.TurnoDTO;
import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.example.clinica.repository.ITurnoRepository;
import com.example.clinica.services.OdontologoService;
import com.example.clinica.services.PacienteService;
import com.example.clinica.services.TurnoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TurnoServiceUnitTest {
    private PacienteService pacienteService = Mockito.mock(PacienteService.class);
    private OdontologoService odontologoService = Mockito.mock(OdontologoService.class);
    private ITurnoRepository iTurnoRepository = Mockito.mock(ITurnoRepository.class);;

    private TurnoService turnoService = new TurnoService(iTurnoRepository, pacienteService, odontologoService);

    @Test
    public void guardarTest() {
        PostTurnoDTO postTurnoDTO = new PostTurnoDTO(new Date(), 345, "Juan", "Perez", "MN235");
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Mockito.when(this.pacienteService.buscarDni(345)).thenReturn(paciente);
        Mockito.when(this.odontologoService.getByMatricula("MN235")).thenReturn(odontologo);
        Turno turno = new Turno(new Date(), paciente, odontologo);
        Mockito.when(this.iTurnoRepository.save(Mockito.any())).thenReturn(turno);
        TurnoDTO turnoDTO = new TurnoDTO(0,new Date(), pacienteDTO, odontologoDTO);
        Assert.assertEquals(turnoDTO, this.turnoService.guardar(postTurnoDTO));
    }

    @Test
    public void buscarTodosTest() {
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Turno turno = new Turno(new Date(), paciente, odontologo);
        TurnoDTO turnoDTO = new TurnoDTO(0,new Date(), pacienteDTO, odontologoDTO);
        List<Turno>turnos = new ArrayList<>();
        turnos.add(turno);
        List<TurnoDTO>turnosDTO = new ArrayList<>();
        turnosDTO.add(turnoDTO);
        Mockito.when(this.iTurnoRepository.findAll()).thenReturn(turnos);
        Assert.assertEquals(turnosDTO, this.turnoService.buscarTodos());
    }

    @Test
    public void eliminarTest() {
        this.turnoService.eliminar(1);
        Mockito.verify(this.iTurnoRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void buscarTest() {
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Turno turno = new Turno(new Date(), paciente, odontologo);
        TurnoDTO turnoDTO = new TurnoDTO(0,new Date(), pacienteDTO, odontologoDTO);
        Mockito.when(this.iTurnoRepository.findById(0)).thenReturn(Optional.of(turno));
        Assert.assertEquals(turnoDTO, this.turnoService.buscar(0));
    }
}
