package com.rogueanovi.stock_microservice.categories.domain.port.spi;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
}
