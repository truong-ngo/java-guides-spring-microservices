package com.javaguide.restapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot REST API Documentation",
                description = "Spring boot REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Truong",
                        email = "javaguides.net@gmail.com",
                        url = "https://javaguides.net"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://javaguides.net/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring boot User Management Documentation",
                url = "https://javaguides.net/user_management.html"
        )
)
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}
