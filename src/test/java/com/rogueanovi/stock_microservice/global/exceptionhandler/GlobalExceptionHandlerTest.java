package com.rogueanovi.stock_microservice.global.exceptionhandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler globalExceptionHandler  = new GlobalExceptionHandler();

    @Test
    void testHandleValidationExceptions() {
        // Arrange
        BindingResult bindingResult = new BeanPropertyBindingResult(new Object(), "objeto");
        FieldError fieldError = new FieldError("objeto", "campo", "mensaje de error");
        bindingResult.addError(fieldError);
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

        // Act
        ResponseEntity<Map<String, String>> response = globalExceptionHandler.handleValidationExceptions(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals("mensaje de error", response.getBody().get("campo"));
    }

    @Test
    void testHandleConstraintViolationException() {
        // Arrange
        ConstraintViolationException ex = createConstraintViolationException();
        // Act
        ResponseEntity<Map<String, String>> response = globalExceptionHandler.handleConstraintViolationException(ex);
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals("mensaje de error", response.getBody().get("objeto.campo"));
    }

    private ConstraintViolationException createConstraintViolationException() {
        ConstraintViolationException ex = new ConstraintViolationException(new HashSet<>());
        Set<ConstraintViolation<?>> violations = new HashSet<>();
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        Path path = mock(Path.class);
        when(path.toString()).thenReturn("objeto.campo"); // establece el propertyPath en "objeto.campo"
        when(violation.getPropertyPath()).thenReturn(path);
        when(violation.getMessage()).thenReturn("mensaje de error");
        violations.add(violation);
        ex.getConstraintViolations().addAll(violations);
        return ex;
    }
}
