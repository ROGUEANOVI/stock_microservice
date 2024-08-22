package com.rogueanovi.stock_microservice.brands.domain.usecase;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.domain.port.spi.IListBrandsPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListBrandsUseCaseTest {
    @Mock
    private IListBrandsPersistencePort brandsPersistencePort;

    @InjectMocks
    private ListBrandsUseCase listBrandsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListCategories() {
        // Arrange
        List<Brand> expectedBrands = List.of(new Brand(1L, "Brand 1", "Description 1"), new Brand(2L, "Brand 2", "Description 2"));
        when(brandsPersistencePort.listBrands(0, 10, "asc")).thenReturn(expectedBrands);

        // Act
        List<Brand> actualBrands = listBrandsUseCase.listBrands(0, 10, "asc");

        // Assert
        assertEquals(expectedBrands, actualBrands);
    }

    @Test
    void testListBrandsWithNullPage() {
        // Arrange
        List<Brand> expectedBrands = List.of(new Brand(1L, "Brand 1", "Description 1"), new Brand(2L, "Brand 2", "Description 2"));
        when(brandsPersistencePort.listBrands(null, 10, "asc")).thenReturn(expectedBrands);

        // Act
        List<Brand> actualBrands = listBrandsUseCase.listBrands(null, 10, "asc");

        // Assert
        assertEquals(expectedBrands, actualBrands);
    }

    @Test
    void testListBrandsWithNullSize() {
        // Arrange
        List<Brand> expectedBrands = List.of(new Brand(1L, "Brand 1", "Description 1"), new Brand(2L, "Brand 2", "Description 2"));
        when(brandsPersistencePort.listBrands(0, null, "asc")).thenReturn(expectedBrands);

        // Act
        List<Brand> actualBrands = listBrandsUseCase.listBrands(0, null, "asc");

        // Assert
        assertEquals(expectedBrands, actualBrands);
    }

    @Test
    void testListBrandsWithNullSortDirection() {
        // Arrange
        List<Brand> expectedBrands = List.of(new Brand(1L, "Brand 1", "Description 1"), new Brand(2L, "Brand 2", "Description 2"));
        when(brandsPersistencePort.listBrands(0, 10, null)).thenReturn(expectedBrands);

        // Act
        List<Brand> actualBrands = listBrandsUseCase.listBrands(0, 10, null);

        // Assert
        assertEquals(expectedBrands, actualBrands);
    }
}
