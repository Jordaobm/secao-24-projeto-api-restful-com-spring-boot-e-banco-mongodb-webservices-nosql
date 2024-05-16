package com.springbootmongodb.demo.resources.exceptions;

import com.springbootmongodb.demo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), httpStatus.value(), "Não encontrado", objectNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(err.getStatus()).body(err);
    }

}
