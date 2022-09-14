package com.demo.cloudgatewaysvc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SwaggerConfig {

    private final RouteDefinitionLocator locator;
    @Bean
    public List<GroupedOpenApi> apis(){
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();

        assert definitions != null;

        log.info("Route: {}, ", definitions.size());

        definitions.stream()
                .filter(routeDefinition -> routeDefinition.getId().matches(".*-svc-id"))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId().replaceAll("-svc-id", "");
                    groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
                });
        return groups;
    }
}
