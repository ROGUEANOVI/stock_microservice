package com.rogueanovi.stock_microservice.categories.application.mapper;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequest categoryRequest);
}
