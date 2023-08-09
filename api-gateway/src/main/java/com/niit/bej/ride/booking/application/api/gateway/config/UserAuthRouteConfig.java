package com.niit.bej.ride.booking.application.api.gateway.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(name = "user-auth-service")
public class UserAuthRouteConfig {

}
