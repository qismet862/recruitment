package com.recruitment.config;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.regex(".*"))
                .apis(RequestHandlerSelectors.basePackage("com.recruitment.controller"))
                .build()
//                .securitySchemes(Collections.singletonList(apiKey()))
//                .securityContexts(Collections.singletonList(securityContext()))
                .pathMapping("/")
                .globalOperationParameters(Collections.singletonList(getToken()))
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", HttpHeaders.AUTHORIZATION, "Header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        return Collections.singletonList(
                new SecurityReference("JWT", getAuthorizationScopes()));
    }

    private AuthorizationScope[] getAuthorizationScopes() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope("global", "accessEverything");
        return authorizationScopes;
    }

    private Parameter getToken() {
        return new ParameterBuilder()
                .name("Authorization")
                .description("Token")
                .parameterType("header")
                .modelRef(new ModelRef("string"))
                .required(false)
                .build();
    }
}
