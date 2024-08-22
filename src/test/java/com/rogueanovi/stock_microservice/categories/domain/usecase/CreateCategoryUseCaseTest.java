package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.exception.CategoryAlreadyExistsException;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICreateCategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {
    @Mock
    private ICreateCategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CreateCategoryUseCase createCategoryUseCase;

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category(1L, "Skin care", "Articles to care for and beautify the skin");
    }

    @Test
    void shouldCreateCategorySuccessfully() {
        // Arrange
        when(categoryPersistencePort.existsCategoryByName(category.getName())).thenReturn(false);



        // Act
        createCategoryUseCase.createCategory(category);

        // Assert
        verify(categoryPersistencePort, times(1)).createCategory(any(Category.class));
    }

    @Test
    void shouldThrowCategoryAlreadyExistsException() {
        // Arrange
        when(categoryPersistencePort.existsCategoryByName(category.getName())).thenReturn(true);

        // Act and Assert
        assertThrows(CategoryAlreadyExistsException.class, () -> createCategoryUseCase.createCategory(category));
    }
}

