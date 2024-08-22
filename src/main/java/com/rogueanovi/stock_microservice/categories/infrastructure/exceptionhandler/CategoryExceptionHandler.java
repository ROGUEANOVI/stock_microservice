package com.rogueanovi.stock_microservice.categories.infrastructure.exceptionhandler;

import com.rogueanovi.stock_microservice.brands.domain.exception.constant.BrandExceptionMessages;
import com.rogueanovi.stock_microservice.categories.domain.exception.CategoryAlreadyExistsException;
import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryDescriptionException;
import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryNameException;
import com.rogueanovi.stock_microservice.categories.domain.exception.NoDataFoundCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(InvalidCategoryNameException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBrandNameException(InvalidCategoryNameException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(InvalidCategoryDescriptionException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBrandDescriptionException(InvalidCategoryDescriptionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(BrandExceptionMessages.KEY_MESSAGE, ex.getMessage()));

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
