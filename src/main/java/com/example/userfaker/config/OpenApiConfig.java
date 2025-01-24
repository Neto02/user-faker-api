package com.example.userfaker.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Faker API")
                        .description("API for generating fake user data and exporting it.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Neto Santos")
                                .url("https://github.com/Neto02")
                                .email("netosantos0702@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Repository")
                        .url("https://github.com/Neto02/user-faker-api"));
    }
}
