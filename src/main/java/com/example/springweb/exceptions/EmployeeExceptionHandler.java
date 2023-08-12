package com.example.springweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EmployeeNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Сотрудник с id = %d не найден".formatted(e.getId()));
    }

}
