package com.eldar.business.jiraextractor.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder()
                .group("Eldar")
                .packagesToScan("com.eldar.business.jiraextractor")
                .build();
    }

    @Bean
    public OpenAPI springOpenApi(){
        String version = "1.0";
        return new OpenAPI()
                .info(new Info().title("ELDAR - Jira Extractor - Plataforma")
                        .description("Extraccion de Status de Jira de Personal ELDAR")
                        .contact(new Contact().name("Sebastian J. Acosta S.").email("sebastian.acosta@eldars.com.ar"))
                        .version(version));
    }
}
