package com.example.clinica;

import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.services.OdontologoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceIntegrationTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    @Transactional
    public void integrationTest() {
        OdontologoDTO o = odontologoService.guardar(new Odontologo("998", "Fede", "Gomez"));
        Odontologo d = odontologoService.getByMatricula(o.getMatricula());
        List<OdontologoDTO> odontologos = odontologoService.buscarTodos();
        Assert.assertFalse(odontologos.isEmpty());
        Assert.assertNotNull(odontologoService.buscar(o.getId()));
        odontologoService.eliminar(d.getId());
    }





}

