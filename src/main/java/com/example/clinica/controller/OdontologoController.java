package com.example.clinica.controller;
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
    public List<Odontologo> listaOdontologos(){
        return this.odontologoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable("id") int id) {
        ResponseEntity<Odontologo> response;

        if(this.odontologoService.buscar(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            response = ResponseEntity.ok(this.odontologoService.buscar(id));
        }
        return response;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(
            @PathVariable("id") int id) {
        ResponseEntity response = null;
        if (odontologoService.buscar(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.guardar(odontologo));

    }

    //@PutMapping()
    //public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) {
      //  ResponseEntity<Odontologo> response = null;

        //if(odontologoService.buscar(odontologo.getId()) == null){
          //  response = new ResponseEntity(HttpStatus.NOT_FOUND);
        //} else {
          //  response = new ResponseEntity(odontologoService.actualizar(odontologo), HttpStatus.OK);
        //}
        //return response;
    //}

}