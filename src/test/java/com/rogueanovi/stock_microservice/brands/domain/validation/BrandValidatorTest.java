package com.rogueanovi.stock_microservice.brands.domain.validation;

import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandException;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BrandValidatorTest {
    @Test
    void shouldThrowInvalidBrandExceptionWhenNameIsNull() {
        // Arrange
        Brand brand = new Brand(null, null, "Description");

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldThrowInvalidBrandExceptionWhenNameIsBlank() {
        // Arrange
        Brand brand = new Brand(null, " ", "Description");

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldThrowInvalidBrandExceptionWhenNameIsTooLong() {
        // Arrange
        Brand brand = new Brand(null, "a".repeat(51), "Description");

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldNotThrowExceptionWhenNameIsValid() {
        // Arrange
        Brand brand = new Brand(null, "Koaj", "Description");

        // Act and Assert
        assertDoesNotThrow(() -> BrandValidator.validate(brand));
    }

    @Test
    void shouldThrowInvalidBrandDescriptionExceptionWhenDescriptionIsNull() {
        // Arrange
        Brand brand = new Brand(null, "Koaj", null);

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldThrowInvalidBrandExceptionWhenDescriptionIsBlank() {
        // Arrange
        Brand brand = new Brand(null, "Koaj", "");

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldThrowInvalidBrandExceptionWhenDescriptionIsTooLong() {
        // Arrange
        Brand brand = new Brand(null, "Koaj", "a".repeat(121));

        // Act and Assert
        assertThrows(InvalidBrandException.class, () -> BrandValidator.validate(brand));
    }

    @Test
    void shouldNotThrowExceptionWhenDescriptionIsValid() {
        // Arrange
        Brand brand = new Brand(null, "Koaj", "Ropa, Tenis y Accesorios para Mujer y Hombre");

        // Act and Assert
        assertDoesNotThrow(() -> BrandValidator.validate(brand));
    }
}
