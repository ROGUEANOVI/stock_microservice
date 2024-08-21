package com.rogueanovi.stock_microservice.brands.domain.exception;

public class InvalidBrandNameException extends RuntimeException {
    public InvalidBrandNameException(String message) {
        super(message);
    }
}
