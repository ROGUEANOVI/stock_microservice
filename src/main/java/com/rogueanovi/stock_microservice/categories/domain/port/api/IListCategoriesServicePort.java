package com.rogueanovi.stock_microservice.categories.domain.port.api;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;

import java.util.List;

public interface IListCategoriesServicePort {
    List<Category> listCategories(Integer page, Integer size, String sortDirection);
}
