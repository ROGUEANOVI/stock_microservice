package com.rogueanovi.stock_microservice.categories.infrastructure.exceptionhandler;

import com.rogueanovi.stock_microservice.categories.domain.exception.CategoryAlreadyExistsException;
import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.exception.NoDataFoundCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCategoryException(InvalidCategoryException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getErrors().forEach(error -> errors.put(error.keySet().iterator().next(), error.values().iterator().next()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlReadyExistsException(CategoryAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(CategoryExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(NoDataFoundCategoryException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundCategoryException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(CategoryExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }
}
