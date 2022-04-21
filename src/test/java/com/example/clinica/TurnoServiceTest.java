package com.example.clinica;

import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.dto.TurnoDTO;
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

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


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


    @Test
    @Transactional
    public void agregarBuscarYEliminarTurnoTest() {
        Domicilio domicilio = new Domicilio("700", "123", "Temperley", "Buenos Aires");
        this.pacienteService.guardar(new Paciente ("Tomas", "Pereyra", 3243234, new Date(), domicilio));
        this.odontologoService.guardar(new Odontologo("998", "Fede", "Gomez"));
        TurnoDTO t = this.turnoService.guardar(new PostTurnoDTO(new Date(), 3243234, "Fede", "Gomez","998"));
        List<TurnoDTO> turnos = this.turnoService.buscarTodos();
        Assert.assertFalse(turnos.isEmpty());
        Assert.assertNotNull(this.turnoService.buscar(t.getId()));
        this.turnoService.eliminar(t.getId());
        Odontologo o = odontologoService.getByMatricula("998");
        Paciente p = this.pacienteService.buscarDni(3243234);
        this.odontologoService.eliminar(o.getId());
        this.pacienteService.eliminar(p.getId());
    }
}


