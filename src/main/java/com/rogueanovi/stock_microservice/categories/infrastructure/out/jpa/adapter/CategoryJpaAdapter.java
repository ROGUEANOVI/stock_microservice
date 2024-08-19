package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.CategoryAlReadyExistsException;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntitymapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntitymapper categoryEntitymapper;

    @Override
    public void saveCategory(Category category) {
        if(categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlReadyExistsException();
        }
        categoryRepository.save(categoryEntitymapper.toEntity(category));
    }
}
