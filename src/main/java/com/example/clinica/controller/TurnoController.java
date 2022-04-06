package com.example.clinica.controller;


import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.Turno;
import com.example.clinica.services.OdontologoService;
import com.example.clinica.services.PacienteService;
import com.example.clinica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")

public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        //controlar si los id son existentes
        Paciente paciente = pacienteService.buscar(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscar(turno.getOdontologo().getId());
        //control
        if (paciente != null && odontologo != null) {
            response = ResponseEntity.ok(turnoService.guardar(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping()
    public ResponseEntity<List<Turno>> listarTurnos() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable("id") int id) {
        ResponseEntity<Turno> response = null;

        if (turnoService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(turnoService.buscar(id), HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(
            @PathVariable("id") int id) {
        ResponseEntity response = null;

        if (this.turnoService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            this.turnoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
}

    //@PutMapping()
    //public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
      //  ResponseEntity response = null;
        //if(turnoService.buscar(turno.getId()) == null ){
         //   response = new ResponseEntity(HttpStatus.NOT_FOUND);
        //} else{
          //  response = new ResponseEntity(turnoService.actualizar(turno),HttpStatus.OK);
        //}
        //return response;

