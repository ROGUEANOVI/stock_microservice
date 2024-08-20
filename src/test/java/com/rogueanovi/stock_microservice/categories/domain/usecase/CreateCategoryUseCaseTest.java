package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateCategoryUseCaseTest {
    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CreateCategoryUseCase createCategoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateCategorySuccessfully() {
        // Arrange
        Category category = new Category(null, "Electronics", "All kinds of electronics");

        // Act
        createCategoryUseCase.createCategory(category);

        // Assert
        verify(categoryPersistencePort, times(1)).createCategory(any(Category.class));
    }
}

