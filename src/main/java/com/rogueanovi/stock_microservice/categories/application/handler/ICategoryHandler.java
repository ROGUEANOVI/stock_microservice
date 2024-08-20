package com.rogueanovi.stock_microservice.categories.application.handler;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;

public interface ICategoryHandler {
    void createCategory(CategoryRequest categoryRequest);
}
