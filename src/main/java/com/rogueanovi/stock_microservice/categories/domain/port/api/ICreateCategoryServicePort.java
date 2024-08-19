package com.rogueanovi.stock_microservice.categories.domain.port.api;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;

public interface ICreateCategoryServicePort {
    void createCategory(Category category);
}
