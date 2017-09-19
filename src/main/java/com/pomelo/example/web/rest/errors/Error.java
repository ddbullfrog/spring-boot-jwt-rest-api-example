package com.pomelo.example.web.rest.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for transferring error message with a list of field errors.
 */
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;

    private List<FieldError> fieldErrors;

    public Error(String message) {
        this(message, null);
    }

    public Error(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public Error(String message, String description, List<FieldError> fieldErrors) {
        this.message = message;
        this.description = description;
        this.fieldErrors = fieldErrors;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldError(objectName, field, message));
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
