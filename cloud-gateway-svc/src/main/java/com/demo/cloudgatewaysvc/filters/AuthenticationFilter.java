package com.demo.cloudgatewaysvc.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final RouterValidator routerValidator;

    @Override
    public GatewayFilter apply(Config config) {
        log.info("Start authentication filter");
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("========================================");
            log.info("Request Url: {}", request.getURI().getPath());

            String bearerToken = request.getHeaders().getFirst("Authorization");
            log.info("Bearer Token {}, ", bearerToken);

            if(routerValidator.isSecured.test(request)){
                log.info("the uri : " + request.getURI().getPath() + " is authorized uri");
                log.info("the method : "+ request.getMethod());
            }

            log.info("the uri : "+ request.getURI().getPath()+  " not authorized uri");
            log.info("the method : "+ request.getMethod());

            return chain.filter(exchange);
        };

    }
    public static class Config {

    }
}
