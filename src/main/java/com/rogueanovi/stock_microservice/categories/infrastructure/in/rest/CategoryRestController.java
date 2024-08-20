package com.rogueanovi.stock_microservice.categories.infrastructure.in.rest;

import com.rogueanovi.stock_microservice.categories.application.dto.CategoryRequest;
import com.rogueanovi.stock_microservice.categories.application.dto.CategoryResponse;
import com.rogueanovi.stock_microservice.categories.application.handler.ICategoryHandler;
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
@RequestMapping("/categories")
@RequiredArgsConstructor
@Validated
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Create new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content),
            @ApiResponse(responseCode = "400", description = "Category request not valid", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        categoryHandler.createCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "List categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List categories", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categories not found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> listCategories(
            @RequestParam(defaultValue = "0" ) @Min(value = 0, message = "Page number must be 0 or greater") Integer page,
            @RequestParam(defaultValue = "10") @Positive @Min(value = 1, message = "Page size must be 1 or greater") Integer size,
            @RequestParam(defaultValue = "asc") @Pattern(regexp = "(?i)^(asc|desc)$", message = "Sort direction must be asc or desc") String sortDirection) {

        List<CategoryResponse> categoryResponseList = categoryHandler.listCategories(page, size, sortDirection);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseList);
    }
}
