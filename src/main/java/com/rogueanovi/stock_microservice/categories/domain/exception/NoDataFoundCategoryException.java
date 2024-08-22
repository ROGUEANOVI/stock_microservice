package com.rogueanovi.stock_microservice.categories.domain.exception;

public class NoDataFoundCategoryException extends RuntimeException {
    public NoDataFoundCategoryException(String message) {
        super(message);
    }
}
