package com.example.clinica;

import com.example.clinica.entity.Domicilio;
import com.example.clinica.entity.Paciente;
import com.example.clinica.services.PacienteService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    private static PacienteService pacienteService;
    static Paciente p1;
    static Paciente p2;
    static Paciente p3;

    @BeforeClass
    public static void doBefore() {
        Domicilio domicilio1 = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        p1 = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio1));
        Domicilio domicilio2 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        p2  = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio2));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        p3 = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));

        assertNotNull(pacienteService.buscar(p3.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        assertTrue(pacienteService.buscar(3) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        assertTrue(!pacientes.isEmpty());
        assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

}

