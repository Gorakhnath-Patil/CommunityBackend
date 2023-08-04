package com.dirt.home.exception;

public class ResourceNotFoundException extends RuntimeException {
    private Long resourceId;

    public ResourceNotFoundException(String message, String resourceName, Long resourceId) {
        super(message + ": " + resourceName + " with ID " + resourceId + " not found.");
        this.resourceId = resourceId;
    }

    public ResourceNotFoundException(String message, Throwable cause, String resourceName, Long resourceId) {
        super(message + ": " + resourceName + " with ID " + resourceId + " not found.", cause);
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }
}
