package com.example.clinica;

import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.example.clinica.services.OdontologoService;
import com.example.clinica.services.PacienteService;
import com.example.clinica.services.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
        /*
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", 88888888, new Date(), domicilio));
        this.odontologoService.guardar(new Odontologo("EEF45","Santiago", "Paz"));
*/
    }

    @Test
    public void altaTurnoTest(){

       /* this.cargarDataSet();
        turnoService.guardar(new Turno(new Date(), pacienteService.buscar(1),odontologoService.buscar(1)));

        Assert.assertNotNull(turnoService.buscar(1));*/
    }

    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void eliminarTurnoTest(){
        turnoService.eliminar(1);
        Assert.assertFalse(turnoService.buscar(1) == null);
    }
}


