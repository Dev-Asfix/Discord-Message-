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
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Discord Message")
                        .description("Este proyecto implementa una API para la gestión de mensajes programados en Discord, utilizando Spring Boot y Springdoc OpenAPI para la documentación interactiva.")
                        .contact(new Contact()
                                .name("Pablo Rosas")
                                .email("rosasramirez753@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://api/message/api/licencia"))
                )
                ;
    }

}
