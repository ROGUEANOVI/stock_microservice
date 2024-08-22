package com.rogueanovi.stock_microservice.categories.application.handler;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;

public interface ICreateCategoryHandler {
    void createCategory(CategoryRequest categoryRequest);
}
