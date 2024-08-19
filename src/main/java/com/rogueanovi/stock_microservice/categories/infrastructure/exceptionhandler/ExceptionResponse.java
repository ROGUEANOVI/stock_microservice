package com.rogueanovi.stock_microservice.categories.infrastructure.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("There is already a category with that name");
    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }
}