package com.example.clinica.services;
import com.example.clinica.entity.Turno;
import com.example.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    public TurnoService() {}

    public Turno guardar(Turno t){
        return  turnoRepository.save(t);
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(id);
    }

//    public Turno actualizar(Turno t){
//        return turnoRepository.actualizar(t);
//    }

    public Turno buscar(Integer id){
        return turnoRepository.findById(id).get();
    }
}