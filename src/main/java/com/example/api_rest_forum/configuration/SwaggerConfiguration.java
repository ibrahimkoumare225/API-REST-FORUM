package com.example.api_rest_forum.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI getOpenAPI(){
        final Info info = new Info()
                .title("MyForumAPIs")
                .version("0.0.1")
                .description("Theses APIs exposes My Forum endpoints");
        return new OpenAPI().info(info);
    }
}
