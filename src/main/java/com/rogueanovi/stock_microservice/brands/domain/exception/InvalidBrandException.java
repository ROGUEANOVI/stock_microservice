package com.rogueanovi.stock_microservice.brands.domain.exception;

import java.util.List;
import java.util.Map;

public class InvalidBrandException extends RuntimeException {
    private final List<Map<String, String>> errors;

    public InvalidBrandException(List<Map<String, String>> errors) {
        this.errors = errors;
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }
}
