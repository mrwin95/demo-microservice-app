package com.demo.cloudgatewaysvc.config;

import com.demo.cloudgatewaysvc.filters.AuthenticationFilter;
import com.demo.cloudgatewaysvc.filters.RouterValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class GatewayConfig {

    private final RouterValidator routerValidator;

    private final Environment environment;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder,
                                      RouteDefinitionLocator locator,
                                      AuthenticationFilter filter){
        int port = Integer.parseInt(environment.getProperty("server.port"));
        log.info("gateway Routes server port: {}", environment.getProperty("server.port") + locator.getRouteDefinitions());
        return builder.routes()
                .route("auth-svc-id", r ->
                        r.path("/auth-service/**").filters(
                                f -> f.rewritePath("/auth-service(?<segment>/?.*)", "$\\{segment}")
                                        .filter(filter.apply(new AuthenticationFilter.Config())))
                                .uri("lb://auth-svc/"))

                .route("user-svc-id",
                        r -> r.path("/user-service/**").filters(
                                f -> f.rewritePath("/user-service(?<segment>/?.*)","$\\{segment}")
                                        .filter(filter.apply(new AuthenticationFilter.Config())))
                                .uri("lb://user-svc"))

                .route("department-svc-id",
                        r -> r.path("/department-service/**").filters(
                                f -> f.rewritePath("/department-service(?<segment>/?.*)","$\\{segment}")
                                        .filter(filter.apply(new AuthenticationFilter.Config())))
                                .uri("lb://department-svc"))
                .route("employee-svc-id", r -> r.path("/employee-service/**").filters(
                                f -> f.rewritePath("/employee-service(?<segment>/?.*)","$\\{segment}")
                                        .filter(filter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://employee-svc"))
                .route("openapi", r -> r.path("/v3/api-docs/**").filters(f -> f.rewritePath("/v3/api-docs/(?<path>.*)","/$\\{path}/v3/api-docs")).uri("http://localhost:" + port))
                .build();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder webclient(){
        return WebClient.builder();
    }
}
