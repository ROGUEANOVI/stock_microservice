package com.rogueanovi.stock_microservice.brands.domain.exception.constant;

public class BrandExceptionMessages {
    private BrandExceptionMessages() {}
    public static final String KEY_MESSAGE = "Message";
    public static final String INVALID_BRAND_NAME = "Brand name cannot be null, empty, or longer than 50 characters";
    public static final String INVALID_BRAND_DESCRIPTION = "Brand description cannot be null, empty, or longer than 120 characters";
    public static final String BRAND_ALREADY_EXISTS = "Brand already exists";
}