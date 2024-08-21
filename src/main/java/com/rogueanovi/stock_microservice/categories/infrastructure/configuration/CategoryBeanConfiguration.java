package com.rogueanovi.stock_microservice.categories.infrastructure.configuration;

import com.rogueanovi.stock_microservice.categories.domain.port.api.ICreateCategoryServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.api.IListCategoriesServicePort;
import com.rogueanovi.stock_microservice.categories.domain.port.spi.ICategoryPersistencePort;
import com.rogueanovi.stock_microservice.categories.domain.usecase.CreateCategoryUseCase;
import com.rogueanovi.stock_microservice.categories.domain.usecase.ListCategoriesUseCase;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper.CategoryEntitymapper;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CategoryBeanConfiguration {
    private final CategoryEntitymapper categoryEntitymapper;
    private final ICategoryRepository categoryRepository;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntitymapper);
    }

    @Bean
    public ICreateCategoryServicePort createCategoryServicePort(){
        return new CreateCategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IListCategoriesServicePort listCategoriesServicePort(){
        return new ListCategoriesUseCase(categoryPersistencePort());
    }
}
