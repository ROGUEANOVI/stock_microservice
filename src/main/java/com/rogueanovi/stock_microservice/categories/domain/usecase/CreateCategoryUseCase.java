package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.exception.CategoryAlreadyExistsException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.api.ICreateCategoryServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICreateCategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.domain.validation.CategoryValidator;

public class CreateCategoryUseCase implements ICreateCategoryServicePort {
    private final ICreateCategoryPersistencePort categoryPersistencePort;

    public CreateCategoryUseCase(ICreateCategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        CategoryValidator.validateName(category.getName());
        CategoryValidator.validateDescription(category.getDescription());
        if (categoryPersistencePort.existsCategoryByName(category.getName())) {
            throw new CategoryAlreadyExistsException(CategoryExceptionMessages.CATEGORY_ALREADY_EXISTS);
        }
        this.categoryPersistencePort.createCategory(category);
    }
}
