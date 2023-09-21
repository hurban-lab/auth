package com.hurbanlab.auth.controller;

import com.hurbanlab.auth.error.DefaultErrorCodes;
import com.hurbanlab.auth.error.ResourceNotFoundError;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Log4j2
public class AuthController {

    @Value("${spring.application.name:there}")
    private String appName;

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        log.info("Retrieving greetings");
        return new ResponseEntity<>("Hello " + appName, HttpStatus.OK);
    }

    @RequestMapping("/bye")
    public ResponseEntity<String> bye() {
        return new ResponseEntity<>("Bye " + appName, HttpStatus.OK);
    }

    @RequestMapping("/notfound")
    public ResponseEntity<String> error() throws ResourceNotFoundError {
        throw new ResourceNotFoundError(DefaultErrorCodes.RESOURCE_NOT_FOUND_ERROR);
    }

    @RequestMapping("/error")
    public ResponseEntity<String> exception() {
        throw new RuntimeException("Oops");
    }
}
