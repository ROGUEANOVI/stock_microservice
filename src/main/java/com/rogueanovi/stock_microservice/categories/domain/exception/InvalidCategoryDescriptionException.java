package com.rogueanovi.stock_microservice.categories.domain.exception;

public class InvalidCategoryDescriptionException extends RuntimeException{
    public InvalidCategoryDescriptionException(String message){
        super(message);
    }
}
