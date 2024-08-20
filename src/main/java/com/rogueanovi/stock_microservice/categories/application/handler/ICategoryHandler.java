package com.rogueanovi.stock_microservice.categories.application.handler;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;
import com.rogueanovi.stock_microservice.categories.application.dto.CategoryResponse;

import java.util.List;

public interface ICategoryHandler {
    void createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> listCategories(Integer page, Integer size, String sortDirection);
}
