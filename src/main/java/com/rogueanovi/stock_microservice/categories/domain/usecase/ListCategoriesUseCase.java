package com.rogueanovi.stock_microservice.categories.domain.usecase;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;

import java.util.List;

public class ListCategoriesUseCase implements IListCategoriesServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public ListCategoriesUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public List<Category> listCategories(Integer page, Integer size, String sortDirection) {
        return categoryPersistencePort.listCategories(page, size, sortDirection);
    }
}
