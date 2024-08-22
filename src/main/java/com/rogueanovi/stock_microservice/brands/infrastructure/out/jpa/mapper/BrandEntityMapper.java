package com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.mapper;

import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import com.rogueanovi.stock_microservice.brands.infrastructure.out.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandEntityMapper {
    BrandEntity toEntity(Brand brand);
    List<Brand> toBrandList(List<BrandEntity> brandEntities);
}