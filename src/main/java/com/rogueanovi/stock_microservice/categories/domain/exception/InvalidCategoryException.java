package com.rogueanovi.stock_microservice.categories.domain.exception;

import java.util.List;
import java.util.Map;

public class InvalidCategoryException extends RuntimeException {
    private final List<Map<String, String>> errors;

    public InvalidCategoryException(List<Map<String, String>> errors) {
        this.errors = errors;
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }
}
