package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICreateCategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCategoryJpaAdapter implements ICreateCategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntitymapper;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(categoryEntitymapper.toEntity(category));
    }

    @Override
    public boolean existsCategoryByName(String name) {
        return categoryRepository.existsByName(name);
    }
}
