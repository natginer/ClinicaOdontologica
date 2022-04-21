package com.example.clinica.controller;
;
import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.dto.PacienteDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.entity.Paciente;
import com.example.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDTO> listaPacientes() {
        return this.pacienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.pacienteService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable("id") int id) {
        this.pacienteService.eliminar(id);
        return new ResponseEntity<>("Id eliminated", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> registrarPaciente (@RequestBody Paciente paciente) {
        this.pacienteService.guardar(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(this.pacienteService.actualizar(paciente));
    }


}






