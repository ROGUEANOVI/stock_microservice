package com.rogueanovi.stock_microservice.brands.application.mapper;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandResponse;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BrandResponseMapper {
    List<BrandResponse> toBrandResponseList(List<Brand> brands);
}
