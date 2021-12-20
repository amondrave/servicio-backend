package com.pragma.cliente.dominio.excepciones;

import com.pragma.cliente.dominio.utilidades.error.Error;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControlador {
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Error> illegalArgumentException(Exception exception) {
        Error error = Error.builder()
                .nombre(exception.getClass().getSimpleName())
                .mensaje(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Error> notFoundException(Exception exception) {
        Error error = Error.builder()
                .nombre(exception.getClass().getSimpleName())
                .mensaje(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> exception(Exception exception) {
        Error error = Error.builder()
                .nombre(exception.getClass().getSimpleName())
                .mensaje(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
