package com.rogueanovi.stock_microservice.brands.domain.validation;

import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandDescriptionException;
import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BrandValidatorTest {
    @Test
    void shouldThrowInvalidBrandNameExceptionWhenNameIsNull() {
        // Arrange
        String name = null;

        // Act and Assert
        assertThrows(InvalidBrandNameException.class, () -> BrandValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidBrandNameExceptionWhenNameIsBlank() {
        // Arrange
        String name = "";

        // Act and Assert
        assertThrows(InvalidBrandNameException.class, () -> BrandValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidBrandNameExceptionWhenNameIsTooLong() {
        // Arrange
        String name = "a".repeat(51);

        // Act and Assert
        assertThrows(InvalidBrandNameException.class, () -> BrandValidator.validateName(name));
    }

    @Test
    void shouldNotThrowExceptionWhenNameIsValid() {
        // Arrange
        String name = "Koaj";

        // Act and Assert
        assertDoesNotThrow(() -> BrandValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidBrandDescriptionExceptionWhenDescriptionIsNull() {
        // Arrange
        String description = null;

        // Act and Assert
        assertThrows(InvalidBrandDescriptionException.class, () -> BrandValidator.validateDescription(description));
    }

    @Test
    void shouldThrowInvalidBrandDescriptionExceptionWhenDescriptionIsBlank() {
        // Arrange
        String description = "";

        // Act and Assert
        assertThrows(InvalidBrandDescriptionException.class, () -> BrandValidator.validateDescription(description));
    }

    @Test
    void shouldThrowInvalidBrandDescriptionExceptionWhenDescriptionIsTooLong() {
        // Arrange
        String description = "a".repeat(121);

        // Act and Assert
        assertThrows(InvalidBrandDescriptionException.class, () -> BrandValidator.validateDescription(description));
    }

    @Test
    void shouldNotThrowExceptionWhenDescriptionIsValid() {
        // Arrange
        String description = "Ropa, Tenis y Accesorios para Mujer y Hombre";

        // Act and Assert
        assertDoesNotThrow(() -> BrandValidator.validateDescription(description));
    }
}
