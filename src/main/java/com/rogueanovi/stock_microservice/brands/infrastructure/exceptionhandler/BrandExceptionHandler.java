package com.rogueanovi.stock_microservice.brands.infrastructure.exceptionhandler;

import com.rogueanovi.stock_microservice.brands.domain.exception.BrandAlreadyExistsException;
import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandDescriptionException;
import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandNameException;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.BrandExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class BrandExceptionHandler {

    @ExceptionHandler(InvalidBrandNameException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBrandNameException(InvalidBrandNameException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(InvalidBrandDescriptionException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBrandDescriptionException(InvalidBrandDescriptionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));

    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleBrandAlreadyExistsException(BrandAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }
}
