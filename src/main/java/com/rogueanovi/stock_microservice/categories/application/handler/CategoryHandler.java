package com.rogueanovi.stock_microservice.categories.application.handler;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;
import com.rogueanovi.stock_microservice.categories.application.dto.CategoryResponse;
import com.rogueanovi.stock_microservice.categories.application.mapper.CategoryRequestMapper;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.api.ICreateCategoryServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {
    private final ICreateCategoryServicePort createCategoryServicePort;
    private final IListCategoriesServicePort listCategoriesServicePort;
    private final CategoryRequestMapper categoryRequestMapper;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toCategory(categoryRequest);
        createCategoryServicePort.createCategory(category);
    }

    @Override
    public List<CategoryResponse> listCategories(Integer page, Integer size, String sortDirection) {
        return categoryRequestMapper.toCategoryResponseList(listCategoriesServicePort.listCategories(page, size, sortDirection));
    }


}
