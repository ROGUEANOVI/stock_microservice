package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.api.ICreateCategoryServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;

public class CreateCategoryUseCase implements ICreateCategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public CreateCategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        this.categoryPersistencePort.createCategory(category);
    }
}

