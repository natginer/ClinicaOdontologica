package com.example.clinica.controller;

import com.example.clinica.dto.OdontologoDTO;
import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;


    @GetMapping()
    public List<OdontologoDTO> listaOdontologos(){
        return this.odontologoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.odontologoService.buscar(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable("id") int id) {
        odontologoService.eliminar(id);
        return new ResponseEntity<>("Id deleted", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.guardar(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }

}