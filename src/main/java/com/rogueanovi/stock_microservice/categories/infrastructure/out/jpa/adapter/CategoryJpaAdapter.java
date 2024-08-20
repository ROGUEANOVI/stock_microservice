package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.CategoryAlReadyExistsException;
import com.rogueanovi.stock_microservice.categories.infrastructure.exception.NoDataFoundException;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity.CategoryEntity;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntitymapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntitymapper categoryEntitymapper;

    @Override
    public void createCategory(Category category) {
        if(categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlReadyExistsException();
        }
        categoryRepository.save(categoryEntitymapper.toEntity(category));
    }

    @Override
    public List<Category> listCategories(Integer page, Integer size, String sortDirection) {
        Pageable pagination = PageRequest.of(page, size);
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "name");

        if (!sort.isEmpty()) pagination = PageRequest.of(page, size).withSort(sort);

        List<CategoryEntity> categoryEntityList = categoryRepository.findAll(pagination).getContent();

        if (categoryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return categoryEntitymapper.toCategoryList(categoryEntityList);
    }
}
