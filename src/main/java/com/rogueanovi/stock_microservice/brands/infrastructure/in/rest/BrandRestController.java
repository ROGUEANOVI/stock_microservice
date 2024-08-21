package com.rogueanovi.stock_microservice.brands.infrastructure.in.rest;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandRequest;
import com.rogueanovi.stock_microservice.brands.application.handler.ICreateBrandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
@Validated
public class BrandRestController {
    private final ICreateBrandHandler createBrandHandler;
    @Operation(summary = "Create new brand")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Brand created", content = @Content),
        @ApiResponse(responseCode = "409", description = "Brand already exists", content = @Content),
        @ApiResponse(responseCode = "400", description = "Brand request not valid", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> createBrand(@Valid @RequestBody BrandRequest brandRequest) {
        createBrandHandler.createBrand(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
