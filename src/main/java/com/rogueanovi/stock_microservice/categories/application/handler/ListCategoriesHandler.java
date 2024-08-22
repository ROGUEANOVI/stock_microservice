package com.rogueanovi.stock_microservice.categories.application.handler;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryResponse;
import com.rogueanovi.stock_microservice.categories.application.mapper.CategoryRequestMapper;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ListCategoriesHandler implements IListCategoriesHandler{
    private final IListCategoriesServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;

    @Override
    public List<CategoryResponse> listCategories(Integer page, Integer size, String sortDirection) {
        return categoryRequestMapper.toCategoryResponseList(categoryServicePort.listCategories(page, size, sortDirection));
    }
}
