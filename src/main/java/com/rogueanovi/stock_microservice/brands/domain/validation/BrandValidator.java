package com.rogueanovi.stock_microservice.brands.domain.validation;

import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandDescriptionException;
import com.rogueanovi.stock_microservice.brands.domain.exception.InvalidBrandNameException;
import com.rogueanovi.stock_microservice.brands.domain.exception.constant.ExceptionMessage;

public class BrandValidator {
    private BrandValidator() {}

    public static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new InvalidBrandNameException(ExceptionMessage.INVALID_BRAND_NAME);
        }
    }

    public static void validateDescription(String description) {
        if (description == null || description.isBlank() || description.length() > 120) {
            throw new InvalidBrandDescriptionException(ExceptionMessage.INVALID_BRAND_DESCRIPTION);
        }
    }
}
