package ru.korushov.superkassa.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Vitaly Korushov
 */

@ControllerAdvice
public class ExampleExceptionHandler {

    @ExceptionHandler(value = {ExampleException.class})
    public ResponseEntity<String> notFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am a teapot");
    }
}

