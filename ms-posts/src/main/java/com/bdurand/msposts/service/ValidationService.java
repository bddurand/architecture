package com.bdurand.msposts.service;

import com.bdurand.msposts.service.exception.ExternalServiceException;
import com.bdurand.msposts.service.exception.UserNotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.io.IOException;

@Slf4j
@Service
public class ValidationService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @param userId
     * @return true if the given userId exists
     */
    @CircuitBreaker(name = "UserExistsValidationService", fallbackMethod = "fallbackUserExists")
    public void userExists(Integer userId) {

        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        try {
            String response = restTemplate.getForObject(url, String.class);
            log.info("Response received from client: {}", response);
        } catch (HttpClientErrorException.NotFound httpExc) {
            log.error("User not found with id: {} ", userId);
            throw new UserNotFoundException("User with id " + userId + " was not found on our systems");
        } catch (HttpServerErrorException | ResourceAccessException  e) {
            log.error("An exception happened: {}", e.getMessage());
            throw new ExternalServiceException("Exception when consuming user-service: " + e.getMessage());
        }
    }
    public void fallbackUserExists(ExternalServiceException ex) {
        log.error("Fallback triggered for userExists due to service error: {}", ex.getMessage());
        throw ex;
    }
}
