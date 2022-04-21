package com.example.clinica;

import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Paciente;
import com.example.clinica.services.PacienteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceIntegrationTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Transactional
    public void integrationTest() {
        Domicilio domicilio = new Domicilio("700", "123", "Temperley", "Buenos Aires");
        PacienteDTO p = pacienteService.guardar(new Paciente ("Tomas", "Pereyra", 12345678, new Date(), domicilio));
        Paciente d = pacienteService.buscarDni(p.getDni());
        List<PacienteDTO> pacientes = pacienteService.buscarTodos();
        Assert.assertFalse(pacientes.isEmpty());
        Assert.assertNotNull(pacienteService.buscar(p.getId()));
        pacienteService.eliminar(d.getId());
    }


}

