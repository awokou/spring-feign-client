package com.server.spring.feign.client.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Configuration class for OpenAPI documentation.
 * 
 * This class uses the @OpenAPIDefinition annotation to provide metadata for the OpenAPI documentation,
 * including information about the API, contact details, license, terms of service, and server environments.
 * 
 * The @OpenAPIDefinition annotation includes:
 * - @Info: Provides general information about the API, such as title, version, description, contact, license, and terms of service.
 * - @Server: Defines the server environments where the API is hosted, including descriptions and URLs.
 * 
 * Example:
 * - Local ENV: http://localhost:8080
 * - PROD ENV: (URL not specified)
 * 
 * Contact Information:
 * - Email: kawokou122@gmail.com
 * 
 * License Information:
 * - Name: Licence name
 * - URL: #
 */
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "", email = "kawokou122@gmail.com", url = "#"),
                description = "OpenApi documentation",
                title = "OpenApi specification",
                version = "1.0",
                license = @License(name = "Licence name", url = "#"),
                termsOfService = "Terms"
        ),
        servers = {
                @Server(description = "Local ENV", url = "http://localhost:8080"),
                @Server(description = "PROD ENV", url = "")
        })
public class OpenApiConfig {}
