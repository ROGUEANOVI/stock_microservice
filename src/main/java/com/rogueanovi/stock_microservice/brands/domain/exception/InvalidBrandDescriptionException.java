package com.rogueanovi.stock_microservice.brands.domain.exception;

public class InvalidBrandDescriptionException extends RuntimeException {
    public InvalidBrandDescriptionException(String message) {
        super(message);
    }
}
