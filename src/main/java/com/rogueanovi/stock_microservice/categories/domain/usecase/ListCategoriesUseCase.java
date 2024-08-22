package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.exception.NoDataFoundCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.IListCategoriesPersistencePort;

import java.util.List;

public class ListCategoriesUseCase implements IListCategoriesServicePort {
    private final IListCategoriesPersistencePort categoriesPersistencePort;

    public ListCategoriesUseCase(IListCategoriesPersistencePort categoriesPersistencePort) {
        this.categoriesPersistencePort = categoriesPersistencePort;
    }

    @Override
    public List<Category> listCategories(Integer page, Integer size, String sortDirection) {
        List<Category> categories = categoriesPersistencePort.listCategories(page, size, sortDirection);
        if (categories.isEmpty()) {
            throw new NoDataFoundCategoryException(CategoryExceptionMessages.NO_DATA_FOUND_CATEGORY);
        }
        return categories;
    }
}
