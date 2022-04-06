package com.example.clinica.controller;
import com.example.clinica.entity.Paciente;
import com.example.clinica.services.OdontologoService;
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

    @GetMapping()
    public List<Paciente> listaPacientes() {
        return this.pacienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId( @PathVariable("id") int id) {
            ResponseEntity<Paciente> response;

            if(this.pacienteService.buscar(id) == null){
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                response = ResponseEntity.ok(this.pacienteService.buscar(id));
            }
            return response;
        }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(
            @PathVariable("id") int id) {
        ResponseEntity response;
        if (this.pacienteService.buscar(id) == null) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            this.pacienteService.eliminar(id);
            response = ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {

        return ResponseEntity.ok(this.pacienteService.guardar(paciente));

    }

    //@PutMapping()
    //public ResponseEntity<Paciente> actualizarPaciente (@RequestBody Paciente paciente) {
      //  ResponseEntity<Paciente> response;

        //if(this.pacienteService.buscar(paciente.getId()) == null){
          //  response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //} else {
          //  response = ResponseEntity.ok(this.pacienteService.actualizar(paciente));
        //}
        //return response;
    //}

}


