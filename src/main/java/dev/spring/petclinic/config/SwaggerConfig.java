package dev.spring.petclinic.config;


import dev.spring.petclinic.util.EnvironmentUtil;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static dev.spring.petclinic.constant.EnvironmentConstant.Constants.DEV_ENV;
import static dev.spring.petclinic.constant.UrlConstants.LOCAL_SERVER_URL;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final EnvironmentUtil environmentUtil;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()).info(apiInfo());
    }
    private Info apiInfo() {
        return new Info()
                .title("Pet Clinic")
                .description("Pet clinic 문서")
                .version("1.0");
    }

    private List<Server> swaggerServers() {
        Server server = new Server().url(getServerUrl());
        return List.of(server);
    }

    private String getServerUrl() {
        return LOCAL_SERVER_URL;
    }
}
