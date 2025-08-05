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
/*  NOTE -> @LoadBalanced allows the web client to resolve service name via Eureka,
 means even in future the uRL of a particular service changed,
still this service can call/ interact with the help  of name  registered on the Eureka server
 No need to know the exact URL on which  the service is registered or running to call
@LoadBalanced: Ensures the WebClient uses Spring Cloud LoadBalancer/Eureka to resolve
"USER-SERVICE" to an actual host and port. So you don’t hardcode URLs or ports.

userServiceWebClient becomes a service discovery–aware HTTP client targeting user-service.
 explanation of->
 public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
🔧 What is WebClient.Builder?
WebClient.Builder is used to configure and create instances of WebClient.

It allows you to:

Set a base URL

Add custom headers (e.g., authorization)

Add filters (like logging, retries, etc.)

Configure codecs, timeouts, etc.

Once configured, you call .build() on it to get an actual WebClient instance for
 making HTTP requests.
🧠 Why return a Builder and not a full WebClient?
Because using the builder:

Promotes reuse: You can customize for different services (user-service, order-service, etc.)

Avoids hardcoding: You can pass different base URLs dynamically

Useful in multi-service microservice environments where each client may need slightly different config.

*/