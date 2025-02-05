package com.server.spring.feign.client.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "",
                        email = "kawokou122@gmail.com",
                        url = "#"
                ),
                description = "OpenApi documentation",
                title = "OpenApi specification",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "#"
                ),
                termsOfService = "Terms"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD ENV",
                        url = ""
                )
        }
)
public class OpenApiConfig {}
