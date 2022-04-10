package com.example.clinica.controller;


import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.dto.TurnoDTO;
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

    @PostMapping()
    public ResponseEntity<?> registrarTurno (@RequestBody PostTurnoDTO postTurnoDTO) {
        this.turnoService.guardar(postTurnoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TurnoDTO>> listarTurnos() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.turnoService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable("id") int id) {
        turnoService.eliminar(id);
        return new ResponseEntity<>("Turno deleted", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<TurnoDTO> actualizar (@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

}