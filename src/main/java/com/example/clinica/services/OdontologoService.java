package com.example.clinica.services;

import com.example.clinica.dto.OdontologoDTO;

import com.example.clinica.entity.Odontologo;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.IOdontologoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService {

    private IOdontologoRespository odontologoRespository;

   @Autowired
    public OdontologoService(IOdontologoRespository odontologoRespository){
       this.odontologoRespository = odontologoRespository;}

    public OdontologoDTO guardar(Odontologo o){
        Odontologo odontologo = odontologoRespository.save(o);
        return OdontologoDTO.mapToOdontologoDTO(odontologo);

   }

    public OdontologoDTO buscar(int id) {
        Odontologo odontologo = odontologoRespository.getById(id);
        return OdontologoDTO.mapToOdontologoDTO(odontologo);
    }

    public List<OdontologoDTO> buscarTodos(){
        List<Odontologo>odontologos = odontologoRespository.findAll();
        return odontologos.stream().map(OdontologoDTO::mapToOdontologoDTO).collect(Collectors.toList());
    }

    public void eliminar(int id){
        odontologoRespository.deleteById(id);
    }

    public OdontologoDTO actualizar(Odontologo o) {
        Odontologo odontologo =  odontologoRespository.save(o);
        return OdontologoDTO.mapToOdontologoDTO(odontologo);
    }


    public Odontologo getByMatricula(String matricula){
        return this.odontologoRespository.getByMatricula(matricula).orElseThrow(() -> new NotFoundException("Odontologo not found"));
    }

}
