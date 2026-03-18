package com.kavish.tutorials.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class UserInformationImpl implements UserInformation {

    @Value("${ms-users.port}")
    private String port;
    @Value("${ms-users.host}")
    private String host;
    @Value("${getusers-resource-url}")
    private String resource;
    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "userFallBackMechanism")
    @Override
    public String getUsers() throws Exception {
        ResponseEntity<String> response = template.exchange(createUrl(host, port, resource), HttpMethod.GET, requestEntity(), String.class);
        return response.getBody();
    }

    private String createUrl(String host, String port, String resource) {
        return host + ":" + port + resource;
    }

    private HttpEntity requestEntity() {
        Headers header = new Headers();
        header.set("Content-Type", "application/json");
        return new HttpEntity(header);
    }

    @SuppressWarnings("unused")
    private String userFallBackMechanism() {
        return "CIRCUIT BREAKER ENABLED!!! No Response From Users at this moment. " +
                "Service will be back shortly" + new Date();
    }
}
