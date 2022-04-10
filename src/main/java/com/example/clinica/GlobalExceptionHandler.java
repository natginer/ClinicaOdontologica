package com.example.clinica;

import com.example.clinica.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Executable;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({EmptyResultDataAccessException.class, EntityNotFoundException.class})
    public ResponseEntity<?> notFound(Exception ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> pacienteNotFound(Exception ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}