package com.hurbanlab.auth.error;

public class ResourceNotFoundError extends AuthError {

    public ResourceNotFoundError(String errorCode) {
        super(errorCode);
    }

    public ResourceNotFoundError(String errorCode, String message) {
        super(errorCode, message);
    }
    public ResourceNotFoundError(DefaultErrorCodes errors) {
        super(errors.getCode(), errors.getDescription());
    }
}
