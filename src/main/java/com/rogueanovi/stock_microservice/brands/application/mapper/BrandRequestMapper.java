
package com.rogueanovi.stock_microservice.brands.application.mapper;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandRequest;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandRequestMapper {
    Brand toBrand(BrandRequest brandRequest);
}

