package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.IListCategoriesPersistencePort;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity.CategoryEntity;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ListCategoriesJpaAdapter implements IListCategoriesPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntitymapper;

    @Override
    public List<Category> listCategories(Integer page, Integer size, String sortDirection) {
        Pageable pagination = PageRequest.of(page, size);
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "name");

        if (!sort.isEmpty()) pagination = PageRequest.of(page, size).withSort(sort);

        List<CategoryEntity> categoryEntityList = categoryRepository.findAll(pagination).getContent();

        return categoryEntitymapper.toCategoryList(categoryEntityList);
    }
}
