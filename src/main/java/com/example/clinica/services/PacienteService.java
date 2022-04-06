package com.example.clinica.services;
import com.example.clinica.entity.Paciente;
import com.example.clinica.repository.IDomicilioRepository;
import com.example.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    IDomicilioRepository domicilioRepository;

        public PacienteService(){
        }

        public Paciente guardar(Paciente p){ return pacienteRepository.save(p);}


        public Paciente buscar(int id){
            return pacienteRepository.getById(id);}

        public List<Paciente> buscarTodos(){
            return pacienteRepository.findAll();
        }

        public void eliminar(int id){
            pacienteRepository.deleteById(id);
        }

    //    public Paciente actualizar(Paciente p){
//        return pacienteRepository.actualizar(p);
//    }


    }
