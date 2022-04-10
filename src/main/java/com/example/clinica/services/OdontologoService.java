package com.example.clinica.services;

import com.example.clinica.dto.OdontologoDTO;

import com.example.clinica.dto.PostTurnoDTO;
import com.example.clinica.entity.Odontologo;
import com.example.clinica.exceptions.NotFoundException;
import com.example.clinica.repository.IGetOdontoogoRepository;
import com.example.clinica.repository.IOdontologoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;;
import java.util.stream.Collectors;

@Service
public class OdontologoService {

   @Autowired
    IOdontologoRespository odontologoRespository;

   @Autowired
   IGetOdontoogoRepository iGetOdontoogoRepository;

    public OdontologoService(){}

    public OdontologoDTO guardar(Odontologo o){
        Odontologo odontologo = odontologoRespository.save(o);
        OdontologoDTO odontologoDTO = new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(), odontologo.getMatricula());
        return odontologoDTO;
    }

    public OdontologoDTO buscar(int id) {
        Odontologo odontologo = odontologoRespository.getById(id);
        OdontologoDTO odontologoDTO = new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),
               odontologo.getMatricula());
        return odontologoDTO;
    }

    public List<OdontologoDTO> buscarTodos(){
        List<Odontologo>odontologos = odontologoRespository.findAll();
        return odontologos.stream().map(odontologo -> new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),
                odontologo.getMatricula())).collect(Collectors.toList());
    }

    public void eliminar(int id){
        odontologoRespository.deleteById(id);
    }

    public OdontologoDTO actualizar(Odontologo o) {
        Odontologo odontologo =  odontologoRespository.save(o);
        OdontologoDTO odontologoDTO = new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(), odontologo.getMatricula());
        return odontologoDTO;
    }

    public Odontologo getByNombreYApellido(PostTurnoDTO postTurnoDTO){
        return this.iGetOdontoogoRepository.getByNombreApellido(postTurnoDTO).orElseThrow(() -> new NotFoundException("Odontologo not found"));
    }

    public Odontologo getByMatricula(PostTurnoDTO matricula){
        return this.iGetOdontoogoRepository.getByMatricula(matricula).orElseThrow(() -> new NotFoundException("Odontologo not found"));
    }

    public OdontologoDTO getByMatriculaDto (PostTurnoDTO matricula){
        Odontologo odontologo = this.getByMatricula(matricula);
        return new OdontologoDTO(odontologo.getId(), odontologo.getNombre(),odontologo.getApellido(),
                odontologo.getMatricula());
    }
}
