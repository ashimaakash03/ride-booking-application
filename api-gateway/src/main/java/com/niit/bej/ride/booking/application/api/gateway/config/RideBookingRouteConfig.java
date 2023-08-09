package com.niit.bej.ride.booking.application.api.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(name = "booking-app-service")
public class RideBookingRouteConfig {

    @Bean
    @LoadBalanced
    public RouteLocator locateBookingAppMicroserviceRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(routePredicate -> routePredicate.path("/api/v1/rides/**")
                        .uri("lb://booking-app-service"))
                .build();
    }
}
