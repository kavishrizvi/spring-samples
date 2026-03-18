package com.kavish.tutorials.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@Service
public class UserInformationImpl implements UserInformation {

    private static final Logger log = LoggerFactory.getLogger(UserInformationImpl.class);

    @Value("${ms-users.port}")
    private String port;

    @Value("${ms-users.host}")
    private String host;

    @Value("${getusers-resource-url}")
    private String resource;

    private final RestTemplate template;

    public UserInformationImpl(RestTemplate template) {
        this.template = template;
    }

    @HystrixCommand(
            fallbackMethod = "userFallBackMechanism",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    @Override
    public String getUsers() {

        String url = createUrl(host, port, resource);
        log.info("Calling USER service: {}", url);

        ResponseEntity<String> response =
                template.exchange(url, HttpMethod.GET, requestEntity(), String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Downstream failure: " + response.getStatusCode());
        }

        log.info("Response status: {}", response.getStatusCode());
        return response.getBody();
    }

    private String createUrl(String host, String port, String resource) {
        return UriComponentsBuilder.fromHttpUrl(host)
                .port(Integer.parseInt(port))
                .path(resource)
                .toUriString();
    }

    private HttpEntity<?> requestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }

    @SuppressWarnings("unused")
    private String userFallBackMechanism(Throwable t) {
        log.error("Fallback triggered: {}", t.getMessage());
        return "CIRCUIT BREAKER ENABLED - fallback at " + new Date();
    }
}