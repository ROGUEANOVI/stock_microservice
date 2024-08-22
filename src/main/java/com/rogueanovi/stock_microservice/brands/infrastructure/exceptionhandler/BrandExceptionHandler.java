package com.rogueanovi.stock_microservice.brands.infrastructure.exceptionhandler;

import com.rogueanovi.stock_microservice.brands.domain.exception.*;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.BrandExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BrandExceptionHandler {
    @ExceptionHandler(InvalidBrandException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBrandException(InvalidBrandException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getErrors().forEach(error -> errors.put(error.keySet().iterator().next(), error.values().iterator().next()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleBrandAlreadyExistsException(BrandAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(NoDataFoundBrandException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundBrandException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }
}
