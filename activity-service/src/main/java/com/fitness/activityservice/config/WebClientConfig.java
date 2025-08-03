package com.fitness.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
    @Bean
    public WebClient userServiceWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder
                .baseUrl("http://USER-SERVICE")
                .build();


    }

}
// NOTE -> @LoadBalanced allows the web client to resolve service name via Eureka,
// means even in future the uRL of a particular service changed,
// still this service can call/ interact with the help  of name  registered on the Eureka server
// No need to know the exact URL on which  the service is registered or running to call