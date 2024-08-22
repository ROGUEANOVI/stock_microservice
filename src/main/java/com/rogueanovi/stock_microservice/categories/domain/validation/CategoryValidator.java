package com.rogueanovi.stock_microservice.categories.domain.validation;

import com.rogueanovi.stock_microservice.categories.domain.exception.InvalidCategoryException;
import com.rogueanovi.stock_microservice.categories.domain.exception.constant.CategoryExceptionMessages;
import com.rogueanovi.stock_microservice.categories.domain.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryValidator {
    private CategoryValidator() {}

    public static void validate(Category category) {
        List<Map<String, String>> errors = new ArrayList<>();

        if (category.getName() == null || category.getName().isBlank() || category.getName().length() > 50) {
            errors.add(Map.of("name", CategoryExceptionMessages.INVALID_CATEGORY_NAME));
        }

        if (category.getDescription() == null || category.getDescription().isBlank() || category.getDescription().length() > 90) {
            errors.add(Map.of("description", CategoryExceptionMessages.INVALID_CATEGORY_DESCRIPTION));
        }

        if (!errors.isEmpty()) {
            throw new InvalidCategoryException(errors);
        }
    }
}
