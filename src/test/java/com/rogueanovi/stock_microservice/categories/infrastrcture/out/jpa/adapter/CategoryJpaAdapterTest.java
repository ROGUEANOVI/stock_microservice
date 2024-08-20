package com.rogueanovi.stock_microservice.categories.infrastrcture.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.CategoryAlReadyExistsException;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.NoDataFoundException;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity.CategoryEntity;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntitymapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
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

    private List<Category> categoryList;
    private List<CategoryEntity> categoryEntityList;

    @BeforeEach
    public void setup() {
        category = new Category(1L, "Test Category", "Test Description");
        categoryList = new ArrayList<>();
        categoryList.add(category);
        categoryEntityList = new ArrayList<>();
        categoryEntityList.add(new CategoryEntity(1L, "Test Category 2", "Test Description 2"));
    }

    @Test
    void testSaveCategorySuccess() {
        // Arrange
        when(categoryRepository.findByName(category.getName())).thenReturn(Optional.empty());

        // Act
        categoryJpaAdapter.createCategory(category);

        // Assert
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    void testSaveCategoryAlreadyExists() {
        // Arrange
        when(categoryRepository.findByName(category.getName())).thenThrow(CategoryAlReadyExistsException.class);

        // Act y Assert
        assertThrows(CategoryAlReadyExistsException.class, () -> categoryJpaAdapter.createCategory(category));
    }

    @Test
    void testListCategoriesOk() {
        // Arrange
        Page<CategoryEntity> page = new PageImpl<>(categoryEntityList);
        when(categoryRepository.findAll(PageRequest.of(0, 10).withSort(Sort.by("name")))).thenReturn(page);
        when(categoryEntitymapper.toCategoryList(categoryEntityList)).thenReturn(categoryList);

        // Act
        List<Category> categories = categoryJpaAdapter.listCategories(0, 10, "ASC");

        // Assert
        assertEquals(1, categories.size());
    }

    @Test
    void testListCategoriesNoDataFoundException() {
        // Arrange
        Page<CategoryEntity> page = new PageImpl<>(new ArrayList<>());
        when(categoryRepository.findAll(PageRequest.of(0, 10).withSort(Sort.by("name")))).thenReturn(page);

        // Act y Assert
        assertThrows(NoDataFoundException.class, () -> categoryJpaAdapter.listCategories(0, 10, "ASC"));
    }

    @Test
    void testListCategoriesPageIsNull() {
        // Act y Assert
        assertThrows(NullPointerException.class, () -> categoryJpaAdapter.listCategories(null, 10, "ASC"));
    }

    @Test
    void testListCategoriesSizeIsNull() {
        // Act y Assert
        assertThrows(NullPointerException.class, () -> categoryJpaAdapter.listCategories(0, null, "ASC"));
    }
}