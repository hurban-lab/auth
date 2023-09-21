package com.hurbanlab.auth.error;

import lombok.Data;

@Data
public class AuthError extends Exception {

    private String errorCode;
    public AuthError(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public AuthError(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AuthError(String errorCode, String message, Throwable ex) {
        super(message, ex);
        this.errorCode = errorCode;
    }

    public AuthError(String errorCode, Throwable ex) {
        super(ex);
        this.errorCode = errorCode;
    }
}
