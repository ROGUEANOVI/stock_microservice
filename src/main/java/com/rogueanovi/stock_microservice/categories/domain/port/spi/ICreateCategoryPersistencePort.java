package com.rogueanovi.stock_microservice.categories.domain.port.spi;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;

public interface ICreateCategoryPersistencePort {
    void createCategory(Category category);
    boolean existsCategoryByName(String name);
}
