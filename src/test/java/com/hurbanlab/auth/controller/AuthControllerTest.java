package com.hurbanlab.auth.controller;

import com.hurbanlab.auth.error.DefaultErrorCodes;
import com.hurbanlab.auth.error.ErrorDescription;
import com.hurbanlab.auth.error.ResourceNotFoundError;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Value("${spring.application.name:auth}")
    private String appName;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloShouldReturnDefaultMessage() throws Exception {
        assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/auth/hello",
                String.class).contains("Hello " + appName));
    }

    @Test
    public void byeShouldReturnDefaultMessage() throws Exception {
        assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/auth/bye",
                String.class).contains("Bye " + appName));
    }

    @Test
    public void getErrorShouldThrowError() throws ResourceNotFoundError {
        ResponseEntity<ErrorDescription> response = this.restTemplate.getForEntity("http://localhost:" + port + "/auth/notfound", ErrorDescription.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(DefaultErrorCodes.RESOURCE_NOT_FOUND_ERROR.getCode(), response.getBody().getCode());
    }

    @Test
    public void getExceptionShouldThrowError() {
        ResponseEntity<ErrorDescription> response = this.restTemplate.getForEntity("http://localhost:" + port + "/auth/error", ErrorDescription.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(DefaultErrorCodes.GENERIC_ERROR.getCode(), response.getBody().getCode());
    }
}
