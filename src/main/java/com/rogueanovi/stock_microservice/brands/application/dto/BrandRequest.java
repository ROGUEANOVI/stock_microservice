package com.rogueanovi.stock_microservice.brands.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequest {
    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 120)
    private String description;
}
