package com.yadv.your_adventure.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:8080/swagger-ui/index.html#/

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI expenseAPI() {
        return new OpenAPI()
                .info(new Info().title("Your Adventure")
                        .description("API best dnd social media and best dnd map creator")
                        .version("v0.0.1")
                        .license(new License().name("Apache License Version 2.0").url("https://8081")))
                .externalDocs(new ExternalDocumentation()
                        .description("Expense Tracker Wiki Documentation")
                        .url("https://expensetracker.wiki/docs"));
    }
}
