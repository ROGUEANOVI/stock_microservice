package com.rogueanovi.stock_microservice.categories.infrastructure.configuration;

import com.rogueanovi.stock_microservice.categories.domain.port.api.ICreateCategoryServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICreateCategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.IListCategoriesPersistencePort;
import com.rogueanovi.stock_microservice.categories.domain.usecase.CreateCategoryUseCase;
import com.rogueanovi.stock_microservice.categories.domain.usecase.ListCategoriesUseCase;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter.CreateCategoryJpaAdapter;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter.ListCategoriesJpaAdapter;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CategoryBeanConfiguration {
    private final CategoryEntityMapper categoryEntitymapper;
    private final ICategoryRepository categoryRepository;

    @Bean
    public ICreateCategoryPersistencePort createCategoryPersistencePort(){
        return new CreateCategoryJpaAdapter(categoryRepository, categoryEntitymapper);
    }

    @Bean
    public ICreateCategoryServicePort createCategoryServicePort(){
        return new CreateCategoryUseCase(createCategoryPersistencePort());
    }

    @Bean
    public IListCategoriesPersistencePort listCategoriesPersistencePort(){
        return new ListCategoriesJpaAdapter(categoryRepository, categoryEntitymapper);
    }

    @Bean
    public IListCategoriesServicePort listCategoriesServicePort(){
        return new ListCategoriesUseCase(listCategoriesPersistencePort());
    }
}
