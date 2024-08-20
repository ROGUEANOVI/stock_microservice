package com.rogueanovi.stock_microservice.categories.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(@Value("${appdescription}") String appDescription, @Value("${appversion}") String appVersion){
        return new OpenAPI()
            .components(new Components())
            .info(
                new Info()
                    .title("Stock API")
                    .description(appDescription)
                    .version(appVersion)
            );
    }
}