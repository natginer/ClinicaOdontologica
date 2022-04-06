package com.example.clinica;

import com.example.clinica.entity.Odontologo;
import com.example.clinica.services.OdontologoService;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    public static OdontologoService odontologoService;
    static Odontologo o1;
    static Odontologo o2;
    static Odontologo o3;
    static Odontologo o4;

    @BeforeClass
    public static void doBefore(){
        o1 = odontologoService.guardar(new Odontologo("Enzo", "Perez", "24242424"));
        o2 = odontologoService.guardar(new Odontologo("Julian", "Alvarez", "9999"));
        o3 = odontologoService.guardar(new Odontologo("Franco", "Armani", "1111"));
        o4 = odontologoService.guardar(new Odontologo("Quinteros", "Juanfer", "1111"));
    }

    @Test
    public void registrarOdontologo() {
        assertNotNull(odontologoService.buscar(o1.getId()));
        assertNotNull(odontologoService.buscar(o2.getId()));
        assertNotNull(odontologoService.buscar(o3.getId()));
    }

    @Test
    public void buscarOdontologo() {
        assertEquals(o1.toString(),odontologoService.buscar(o1.getId()).toString());
        assertEquals(o2.toString(),odontologoService.buscar(o2.getId()).toString());
        assertEquals(o3.toString(),odontologoService.buscar(o3.getId()).toString());
    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertTrue(!odontologos.isEmpty());
        assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }

    @Test
    public void eliminarOdontologo() {
        odontologoService.eliminar(o4.getId());
        assertNull(odontologoService.buscar(o4.getId()));
    }
}

