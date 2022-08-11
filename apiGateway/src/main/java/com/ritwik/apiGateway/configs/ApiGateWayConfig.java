package com.ritwik.apiGateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class will contain the routing logic ...
 *
 * @Configuration
 *    1. Create bean using @Component
 *    2. Make spring aware that this is a configuration class, also to define beans
 *
 * For creating the routing logic:
 *    1. First add the dependency in the pom.xml -> spring-cloud-starter-gateway
 *
 *   RouteLocator interface -> This is used to define the routes
 */

@Configuration
public class ApiGateWayConfig {

    /**
     * To use @Bean annotation :
     *   1. Use it before a method that returns the object whose bean has to be created
     *   2. the class should be annotated with @Configuration
     */

    @Bean
    public RouteLocator gateWayRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/ms1/v1/**")
                .uri("lb://MICROSERVICE1").id("microservice1"))
                .route(r -> r.path("/ms2/v1/**")
                        .uri("lb://MICROSERVICE2").id("microservice2")).build();
    }

}
