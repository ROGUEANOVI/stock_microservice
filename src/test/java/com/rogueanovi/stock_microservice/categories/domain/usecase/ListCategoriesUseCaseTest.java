package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.IListCategoriesPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListCategoriesUseCaseTest {
    @Mock
    private IListCategoriesPersistencePort categoryPersistencePort;

    @InjectMocks
    private ListCategoriesUseCase listCategoriesUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListCategories() {
        // Arrange
        List<Category> expectedCategories = List.of(new Category(1L, "Category 1", "Description 1"), new Category(2L, "Category 2", "Description 2"));
        when(categoryPersistencePort.listCategories(0, 10, "asc")).thenReturn(expectedCategories);

        // Act
        List<Category> actualCategories = listCategoriesUseCase.listCategories(0, 10, "asc");

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testListCategoriesWithNullPage() {
        // Arrange
        List<Category> expectedCategories = List.of(new Category(1L, "Category 1", "Description 1"), new Category(2L, "Category 2", "Description 2"));
        when(categoryPersistencePort.listCategories(null, 10, "asc")).thenReturn(expectedCategories);

        // Act
        List<Category> actualCategories = listCategoriesUseCase.listCategories(null, 10, "asc");

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testListCategoriesWithNullSize() {
        // Arrange
        List<Category> expectedCategories = List.of(new Category(1L, "Category 1", "Description 1"), new Category(2L, "Category 2", "Description 2"));
        when(categoryPersistencePort.listCategories(0, null, "asc")).thenReturn(expectedCategories);

        // Act
        List<Category> actualCategories = listCategoriesUseCase.listCategories(0, null, "asc");

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testListCategoriesWithNullSortDirection() {
        // Arrange
        List<Category> expectedCategories = List.of(new Category(1L, "Category 1", "Description 1"), new Category(2L, "Category 2", "Description 2"));
        when(categoryPersistencePort.listCategories(0, 10, null)).thenReturn(expectedCategories);

        // Act
        List<Category> actualCategories = listCategoriesUseCase.listCategories(0, 10, null);

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }
}
