package com.autotasks.workflow.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerUiConfig {

    @Bean
    public OpenAPI workflowServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AutoTasks - Workflow service")
                        .version("v1.0.0"));
    }
}
