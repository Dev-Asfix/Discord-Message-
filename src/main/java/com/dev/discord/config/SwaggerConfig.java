package com.dev.discord.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Discord Message API")
                        .version("1.0.0")
                        .description("""
                                API para la gestión y programación de mensajes en Discord, desarrollada con Spring Boot.
                                Proporciona endpoints para la creación, actualización y eliminación de mensajes de manera eficiente.
                                Documentación generada con Springdoc OpenAPI.
                                """)
                        .termsOfService("https://github.com/Dev-Asfix/Discord-Message?tab=License-1-ov-file")
                        .contact(new Contact()
                                .name("Pablo Rosas")
                                .email("rosasramirez753@gmail.com")
                                .url("https://github.com/Dev-Asfix"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/Dev-Asfix/Discord-Message?tab=License-1-ov-file"))
                );
    }
}
