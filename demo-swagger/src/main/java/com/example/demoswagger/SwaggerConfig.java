package com.example.demoswagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .description("adesso io posso dire AHA!")
                .title("API incredibile")
                .version("top version of the life");

        return new OpenAPI().info(info);
    }
}
