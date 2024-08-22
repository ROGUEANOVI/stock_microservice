package com.rogueanovi.stock_microservice.brands.domain.validation;

import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandException;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.BrandExceptionMessages;
import com.rogueanovi.stock_microservice.brands.domain.model.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BrandValidator {
    private BrandValidator() {}

    public static void validate(Brand brand) {
        List<Map<String, String>> errors = new ArrayList<>();

        if (brand.getName() == null || brand.getName().isBlank() || brand.getName().length() > 50) {
            errors.add(Map.of("name", BrandExceptionMessages.INVALID_BRAND_NAME));
        }

        if (brand.getDescription() == null || brand.getDescription().isBlank() || brand.getDescription().length() > 120) {
            errors.add(Map.of("description", BrandExceptionMessages.INVALID_BRAND_DESCRIPTION));
        }

        if (!errors.isEmpty()) {
            throw new InvalidBrandException(errors);
        }
    }
}
