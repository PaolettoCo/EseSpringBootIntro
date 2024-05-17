package com.example.democontroller.SweggerConf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SweggerConf {

    public OpenAPI OpenAPI(){
        return new OpenAPI().info(new Info().
                title("ciao").
                version("1.0"));
    }
}
