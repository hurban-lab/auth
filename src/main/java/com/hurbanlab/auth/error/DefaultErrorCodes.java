package com.hurbanlab.auth.error;

public enum DefaultErrorCodes {

    GENERIC_ERROR("AUE-50001", "Something went wrong"),
    RESOURCE_NOT_FOUND_ERROR("AUE-40401", "Resource Not Found");

    private final String code;
    private final String description;

    private DefaultErrorCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
