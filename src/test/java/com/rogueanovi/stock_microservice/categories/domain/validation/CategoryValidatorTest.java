package com.rogueanovi.stock_microservice.categories.domain.validation;

import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CategoryValidatorTest {
    @Test
    void shouldThrowInvalidCategoryExceptionWhenNameIsNull() {
        // Arrange
        Category category = new Category(null, null, "Productora de elementos de belleza");

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldThrowInvalidCategoryExceptionWhenNameIsBlank() {
        // Arrange
        Category category = new Category(null, " ", "Productora de elementos de belleza");

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldThrowInvalidCategoryExceptionWhenNameIsTooLong() {
        // Arrange
        Category category = new Category(null, "a".repeat(51), "Productora de elementos de belleza ");

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldNotThrowExceptionWhenNameIsValid() {
        // Arrange
        Category category = new Category(null, "Belleza", "Description");

        // Act and Assert
        assertDoesNotThrow(() -> CategoryValidator.validate(category));
    }

    @Test
    void shouldThrowInvalidCategoryExceptionWhenDescriptionIsNull() {
        // Arrange
        Category category = new Category(null, "Belleza", null);

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldThrowInvalidCategoryExceptionWhenDescriptionIsBlank() {
        // Arrange
        Category category = new Category(null, "Belleza", "");

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldThrowInvalidCategoryExceptionWhenDescriptionIsTooLong() {
        // Arrange
        Category category = new Category(null, "Belleza", "a".repeat(91));

        // Act and Assert
        assertThrows(InvalidCategoryException.class, () -> CategoryValidator.validate(category));
    }

    @Test
    void shouldNotThrowExceptionWhenDescriptionIsValid() {
        // Arrange
        Category category = new Category(null, "Belleza", "Productora de elementos de belleza");

        // Act and Assert
        assertDoesNotThrow(() -> CategoryValidator.validate(category));
    }
}
