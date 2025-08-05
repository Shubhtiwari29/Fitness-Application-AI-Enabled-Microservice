package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId) {
        log.info("Calling User Validation API for userId: {}", userId);
        try{
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve() // retrieve is going to make the API call
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new RuntimeException("User Not Found: " + userId);
            else if (e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new RuntimeException("Invalid Request: " + userId);
        }
        return false;
    }
    /*What this does:
Calls the User Service endpoint /api/users/{userId}/validate using WebClient.

Uses the base URL via service name (http://USER-SERVICE) and appends the URI path.

.retrieve() initiates the HTTP GET call.

.bodyToMono(Boolean.class) converts the JSON response to a Boolean.

.block() makes the call synchronously, returning a boolean.

If the response status is 404 or 400, you catch it and throw a RuntimeException.*/
}
