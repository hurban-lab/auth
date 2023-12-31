package com.hurbanlab.auth.controller;

import com.hurbanlab.auth.error.DefaultErrorCodes;
import com.hurbanlab.auth.error.ErrorDescription;
import com.hurbanlab.auth.error.ResourceNotFoundError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class ErrorHandlerController {

    @Value("${spring.application.name:catalog-service}")
    private String moduleName;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDescription> handleException(HttpServletRequest request,
                                                            Exception exception) {
        ErrorDescription error = ErrorDescription.buildError(DefaultErrorCodes.GENERIC_ERROR.getCode(),
                moduleName, exception, request);
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFoundError.class})
    public ResponseEntity<ErrorDescription> handleException(HttpServletRequest request,
                                                            ResourceNotFoundError exception) {
        ErrorDescription error = ErrorDescription.buildError(DefaultErrorCodes.RESOURCE_NOT_FOUND_ERROR.getCode(),
                moduleName, exception, request);
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
