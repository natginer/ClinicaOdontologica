package com.example.clinica.services;

import com.example.clinica.entity.Odontologo;
import com.example.clinica.repository.IOdontologoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

   @Autowired
    IOdontologoRespository odontologoRespository;

    public OdontologoService(){}


    public Odontologo buscar(int id){
        return odontologoRespository.getById(id);
    }

    public Odontologo guardar(Odontologo o){
        return odontologoRespository.save(o);
    }

    public List<Odontologo> buscarTodos(){
        List<Odontologo>l =  odontologoRespository.findAll();
        return l;
    }

    public void eliminar(int id){
        odontologoRespository.deleteById(id);
    }

    //    public Odontologo actualizar(Odontologo o){
//        return odontologoRepository.(o);
//    }
}
