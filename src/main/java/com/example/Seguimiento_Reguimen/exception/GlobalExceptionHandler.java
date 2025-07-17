package com.example.Seguimiento_Reguimen.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //captura los RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRunTime(RuntimeException ex){
        Map<String, String> errores = new HashMap<>();
        errores.put("error:" , ex.getMessage());
        return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
    }

    //Maneja errores de validación de @Valid en @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    erros.put(error.getField(), error.getDefaultMessage());
                });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

    // (Opcional) Manejo de validación de parámetros individuales (ej: @RequestParam)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolations(ConstraintViolationException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations()
                .forEach(error -> {
                    errors.put("Parámetro: " ,error.getMessage());
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
