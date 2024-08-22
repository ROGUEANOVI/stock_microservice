package com.rogueanovi.stock_microservice.brands.infrastructure.in.rest;

import com.rogueanovi.stock_microservice.brands.application.dto.BrandRequest;
import com.rogueanovi.stock_microservice.brands.application.dto.BrandResponse;
import com.rogueanovi.stock_microservice.brands.application.handler.ICreateBrandHandler;
import com.rogueanovi.stock_microservice.brands.application.handler.IListBrandsHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
@Validated
public class BrandRestController {
    private final ICreateBrandHandler createBrandHandler;
    private final IListBrandsHandler listBrandsHandler;

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

    @Operation(summary = "List brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List brands", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "Brands not found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<BrandResponse>> listBrands(
            @RequestParam(defaultValue = "0" ) @Min(value = 0, message = "Page number must be 0 or greater") Integer page,
            @RequestParam(defaultValue = "10") @Positive @Min(value = 1, message = "Page size must be 1 or greater") Integer size,
            @RequestParam(defaultValue = "asc") @Pattern(regexp = "(?i)^(asc|desc)$", message = "Sort direction must be asc or desc") String sortDirection) {

        List<BrandResponse> brandResponseList = listBrandsHandler.listBrands(page, size, sortDirection);

        return ResponseEntity.status(HttpStatus.OK).body(brandResponseList);
    }
}
