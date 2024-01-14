package com.eldar.business.hirenhub.config;


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
                .packagesToScan("com.eldar.business.hirenhub")
                .build();
    }

    @Bean
    public OpenAPI springOpenApi(){
        String version = "1.0";
        return new OpenAPI()
                .info(new Info().title("ELDAR - HirenHub - Candidatos")
                        .description("Inyeccion de Postulacion en plataformas de Reclutamiento ELDAR")
                        .contact(new Contact().name("Sebastian J. Acosta S.").email("sebastian.acosta@eldars.com.ar"))
                        .version(version));
    }
}
