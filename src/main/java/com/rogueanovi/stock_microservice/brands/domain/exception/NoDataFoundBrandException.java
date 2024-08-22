package com.rogueanovi.stock_microservice.brands.domain.exception;

public class NoDataFoundBrandException extends RuntimeException{
    public NoDataFoundBrandException(String message) {
        super(message);
    }
}
