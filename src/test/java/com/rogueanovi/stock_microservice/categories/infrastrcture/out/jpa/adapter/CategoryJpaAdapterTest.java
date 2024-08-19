package com.rogueanovi.stock_microservice.categories.infrastrcture.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.CategoryAlReadyExistsException;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntitymapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryJpaAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private CategoryEntitymapper categoryEntitymapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    private Category category;

    @BeforeEach
    public void setup() {
        category = new Category(1L, "Test Category", "Test Description");
    }

    @Test
    void testSaveCategorySuccess() {
        // Arrange
        when(categoryRepository.findByName(category.getName())).thenReturn(Optional.empty());

        // Act
        categoryJpaAdapter.saveCategory(category);

        // Assert
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    void testSaveCategoryAlreadyExists() {
        // Arrange
        when(categoryRepository.findByName(category.getName())).thenThrow(CategoryAlReadyExistsException.class);

        // Act y Assert
        assertThrows(CategoryAlReadyExistsException.class, () -> categoryJpaAdapter.saveCategory(category));
    }
}