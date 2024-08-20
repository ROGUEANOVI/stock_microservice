package com.rogueanovi.stock_microservice.categories.application.mapper;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;
import com.rogueanovi.stock_microservice.categories.application.dto.CategoryResponse;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryRequestMapper {
//    CategoryRequestMapper INSTANCE = Mappers.getMapper(CategoryRequestMapper.class);

//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "description", target = "description")
    Category toCategory(CategoryRequest categoryRequest);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "description", target = "description")
//    CategoryResponse toCategoryResponse(Category category);

    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
}
