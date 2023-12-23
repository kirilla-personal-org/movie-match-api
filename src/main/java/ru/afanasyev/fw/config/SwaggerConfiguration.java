package ru.afanasyev.fw.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "MovieMatch Rest API", version = "v1"))
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("external")
            .pathsToMatch("/api/v1/external/**")
            .build();
    }

    @Bean
    public GlobalOpenApiCustomizer customize() {
        ApiResponse internalError = createApiResponse("Internal server error");
        ApiResponse badRequest = createApiResponse("Bad request");
        ApiResponse unauthorised = createApiResponse("Unauthorised");
        ApiResponse forbidden = createApiResponse("Forbidden");

        return openApi -> openApi.getPaths().values().stream()
            .flatMap(pathItem -> pathItem.readOperations().stream())
            .forEach(operation -> {
                ApiResponses responses = operation.getResponses();
                responses.putIfAbsent("400", badRequest);
                responses.putIfAbsent("401", unauthorised);
                responses.putIfAbsent("403", forbidden);
                responses.putIfAbsent("500", internalError);
            });
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private ApiResponse createApiResponse(String description) {
        return new ApiResponse().description(description);
    }
}
