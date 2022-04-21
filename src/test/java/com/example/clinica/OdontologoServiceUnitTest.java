package com.example.clinica;

import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.repository.IOdontologoRespository;
import com.example.clinica.services.OdontologoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class OdontologoServiceUnitTest {


    IOdontologoRespository iOdontologoRespositoryMock = Mockito.mock(IOdontologoRespository.class);
    OdontologoService odontologoService = new OdontologoService(iOdontologoRespositoryMock);

    @Test
    public void buscarTodosTest() {
        List<OdontologoDTO> odontologosList = new ArrayList<>();

        odontologosList.add(new OdontologoDTO(1,"Juan", "Perez", "MN235"));
        odontologosList.add(new OdontologoDTO(2,"Maria","Rodriguez", "MN489"));
        odontologosList.add(new OdontologoDTO(3,"Tomas","García", "MN259"));
        List<Odontologo> odontologosJPAList = new ArrayList<>();
        odontologosJPAList.add(new Odontologo(1, "MN235", "Juan", "Perez"));
        odontologosJPAList.add(new Odontologo(2, "MN489", "Maria", "Rodriguez"));
        odontologosJPAList.add(new Odontologo(3, "MN259", "Tomas", "García"));
        Mockito.when(this.iOdontologoRespositoryMock.findAll()).thenReturn(odontologosJPAList);
        List<OdontologoDTO> odontologos = odontologoService.buscarTodos();
        Assert.assertFalse(odontologos.isEmpty());
        Assert.assertEquals(3, odontologos.size());
        Assert.assertEquals(odontologosList, odontologos);
    }

    @Test
    public void guardarTest() {
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        Mockito.when(this.iOdontologoRespositoryMock.save(odontologo)).thenReturn(odontologo);
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Assert.assertEquals(odontologoDTO, this.odontologoService.guardar(odontologo));
    }

    @Test
    public void buscarTest() {
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        Mockito.when(this.iOdontologoRespositoryMock.getById(1)).thenReturn(odontologo);
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Assert.assertEquals(odontologoDTO, this.odontologoService.buscar(1));
    }

    @Test
    public void eliminarTest() {
       this.odontologoService.eliminar(1);
       Mockito.verify(this.iOdontologoRespositoryMock, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void actualizarTest() {
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        Mockito.when(this.iOdontologoRespositoryMock.save(odontologo)).thenReturn(odontologo);
        OdontologoDTO odontologoDTO = new OdontologoDTO(1,"Juan", "Perez", "MN235");
        Assert.assertEquals(odontologoDTO, this.odontologoService.actualizar(odontologo));
    }


    @Test
    public void getByMatriculaTest() {
        Odontologo odontologo = new Odontologo(1, "MN235", "Juan", "Perez");
        Mockito.when(this.iOdontologoRespositoryMock.getByMatricula("MN235")).thenReturn(Optional.of(odontologo));
        Assert.assertEquals(odontologo, this.odontologoService.getByMatricula("MN235"));
    }

}
