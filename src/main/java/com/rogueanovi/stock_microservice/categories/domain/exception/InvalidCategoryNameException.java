package com.rogueanovi.stock_microservice.categories.domain.exception;

public class InvalidCategoryNameException extends RuntimeException{
    public InvalidCategoryNameException(String message){
        super(message);
    }
}
