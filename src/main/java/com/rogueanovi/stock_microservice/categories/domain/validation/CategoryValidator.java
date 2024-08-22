package com.rogueanovi.stock_microservice.categories.domain.validation;

import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryDescriptionException;
import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryNameException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;

public class CategoryValidator {
    private CategoryValidator() {}

    public static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new InvalidCategoryNameException(CategoryExceptionMessages.INVALID_CATEGORY_NAME);
        }
    }

    public static void validateDescription(String description) {
        if (description == null || description.isBlank() || description.length() > 90) {
            throw new InvalidCategoryDescriptionException(CategoryExceptionMessages.INVALID_CATEGORY_DESCRIPTION);
        }
    }
}
