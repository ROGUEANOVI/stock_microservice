package com.rogueanovi.stock_microservice.categories.domain.exception.constant;

public class CategoryExceptionMessages {
    public static final String KEY_MESSAGE = "message";
    public static final String INVALID_CATEGORY_NAME = "Category name cannot be null, empty, or longer than 50 characters";
    public static final String INVALID_CATEGORY_DESCRIPTION = "Category description cannot be null, empty, or longer than 90 characters";
    public static final String CATEGORY_ALREADY_EXISTS = "Category already exists";
    public static final String NO_DATA_FOUND_CATEGORY = "No data found category for the requested petition";

    private CategoryExceptionMessages() {}
}
