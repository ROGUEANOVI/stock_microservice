package com.rogueanovi.stock_microservice.categories.domain.port.spi;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void createCategory(Category category);

    List<Category> listCategories(Integer page, Integer size, String sortDirection);
}
