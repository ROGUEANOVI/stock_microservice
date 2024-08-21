package com.rogueanovi.stock_microservice.brands.domain.usecase;

import com.rogueanovi.stock_microservice.brands.domain.exception.BrandAlreadyExistsException;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.ICreateBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateBrandUseCaseTest {
    @Mock
    private ICreateBrandPersistencePort brandPersistencePort;

    @InjectMocks
    private CreateBrandUseCase createBrandUseCase;

    private Brand brand;

    @BeforeEach
    void setUp() {
        brand = new Brand( 1L,"Koaj", "Ropa, Tenis y Accesorios para Mujer y Hombre");
    }

    @Test
    void shouldCreateBrandSuccessfully() {
        // Arrange
        when(brandPersistencePort.existsBrandByName(brand.getName())).thenReturn(false);

        // Act
        createBrandUseCase.createBrand(brand);

        // Assert
        verify(brandPersistencePort, times(1)).createBrand(any(Brand.class));
    }

    @Test
    void shouldThrowBrandAlreadyExistsException() {
        // Arrange
        when(brandPersistencePort.existsBrandByName(brand.getName())).thenReturn(true);

        // Act and Assert
        assertThrows(BrandAlreadyExistsException.class, () -> createBrandUseCase.createBrand(brand));
    }
}
