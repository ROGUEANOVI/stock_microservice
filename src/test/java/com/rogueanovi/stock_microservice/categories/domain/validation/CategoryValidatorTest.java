package com.rogueanovi.stock_microservice.categories.domain.validation;

import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryDescriptionException;
import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CategoryValidatorTest {
    @Test
    void shouldThrowInvalidCategoryNameExceptionWhenNameIsNull() {
        // Arrange
        String name = null;

        // Act and Assert
        assertThrows(InvalidCategoryNameException.class, () -> CategoryValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidCategoryNameExceptionWhenNameIsBlank() {
        // Arrange
        String name = "";

        // Act and Assert
        assertThrows(InvalidCategoryNameException.class, () -> CategoryValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidCategoryNameExceptionWhenNameIsTooLong() {
        // Arrange
        String name = "a".repeat(51);

        // Act and Assert
        assertThrows(InvalidCategoryNameException.class, () -> CategoryValidator.validateName(name));
    }

    @Test
    void shouldNotThrowExceptionWhenNameIsValid() {
        // Arrange
        String name = "Koaj";

        // Act and Assert
        assertDoesNotThrow(() -> CategoryValidator.validateName(name));
    }

    @Test
    void shouldThrowInvalidCategoryDescriptionExceptionWhenDescriptionIsNull() {
        // Arrange
        String description = null;

        // Act and Assert
        assertThrows(InvalidCategoryDescriptionException.class, () -> CategoryValidator.validateDescription(description));
    }

    @Test
    void shouldThrowInvalidCategoryDescriptionExceptionWhenDescriptionIsBlank() {
        // Arrange
        String description = "";

        // Act and Assert
        assertThrows(InvalidCategoryDescriptionException.class, () -> CategoryValidator.validateDescription(description));
    }

    @Test
    void shouldThrowInvalidCategoryDescriptionExceptionWhenDescriptionIsTooLong() {
        // Arrange
        String description = "a".repeat(91);

        // Act and Assert
        assertThrows(InvalidCategoryDescriptionException.class, () -> CategoryValidator.validateDescription(description));
    }

    @Test
    void shouldNotThrowExceptionWhenDescriptionIsValid() {
        // Arrange
        String description = "Productora de elementos de belleza";

        // Act and Assert
        assertDoesNotThrow(() -> CategoryValidator.validateDescription(description));
    }
}
