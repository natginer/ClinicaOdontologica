package com.example.clinica;


import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Paciente;
import com.example.clinica.repository.IPacienteRepository;
import com.example.clinica.services.PacienteService;
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
public class PacienteServiceUnitTest {

    IPacienteRepository iPacienteRepositoryMock = Mockito.mock(IPacienteRepository.class) ;
    PacienteService pacienteService = new PacienteService(iPacienteRepositoryMock);


    @Test
    public void buscarTodosTest() {
        List<PacienteDTO> pacientesList = new ArrayList<>();
        Domicilio d1 = new Domicilio(1,"falsa","123","caba","BsAs");
        Domicilio d2 = new Domicilio(2,"abc","456","caba","BsAs");
        pacientesList.add(new PacienteDTO(1,"Juan","Perez", 345, new Date(),d1));
        pacientesList.add(new PacienteDTO(2,"Maria","Gomez", 678, new Date(),d2));
        List<Paciente> pacientesJPAList = new ArrayList<>();
        pacientesJPAList.add(new Paciente(1,"Juan","Perez", 345, new Date(),d1));
        pacientesJPAList.add(new Paciente(2,"Maria","Gomez", 678, new Date(),d2));
        Mockito.when(this.iPacienteRepositoryMock.findAll()).thenReturn(pacientesJPAList);
        List<PacienteDTO> pacientes = pacienteService.buscarTodos();
        Assert.assertFalse(pacientes.isEmpty());
        Assert.assertEquals(2, pacientes.size());
        Assert.assertEquals(pacientesList, pacientes);
    }

    @Test
    public void guardarPacienteTest(){
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Mockito.when(this.iPacienteRepositoryMock.save(paciente)).thenReturn(paciente);
        Assert.assertEquals(pacienteDTO, this.pacienteService.guardar(paciente));
    }

    @Test
    public void buscarPacienteTest(){
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Mockito.when(this.iPacienteRepositoryMock.getById(1)).thenReturn(paciente);
        Assert.assertEquals(pacienteDTO, this.pacienteService.buscar(1));
    }

    @Test
    public void eliminarTest() {
        this.pacienteService.eliminar(1);
        Mockito.verify(this.iPacienteRepositoryMock, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void actualizarPacienteTest(){
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        PacienteDTO pacienteDTO = new PacienteDTO(1,"Juan","Perez", 345, new Date(),domicilio);
        Mockito.when(this.iPacienteRepositoryMock.save(paciente)).thenReturn(paciente);
        Assert.assertEquals(pacienteDTO, this.pacienteService.actualizar(paciente));
    }

    @Test
    public void buscarPacientePorDniTest(){
        Domicilio domicilio = new Domicilio(1,"700", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente(1,"Juan","Perez", 345, new Date(),domicilio);
        Mockito.when(this.iPacienteRepositoryMock.getByDni(345)).thenReturn(Optional.of(paciente));
        Assert.assertEquals(paciente, this.pacienteService.buscarDni(345));
    }

}

