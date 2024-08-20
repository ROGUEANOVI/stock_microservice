package com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.mapper;

import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import com.rogueanovi.stock_microservice.categories.infrastructure.out.jpa.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntitymapper {
    CategoryEntity toEntity(Category category);
    List<Category> toCategoryList(List<CategoryEntity> categories);
}
