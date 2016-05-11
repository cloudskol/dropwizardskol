package com.cloudskol.dropwizardskol.core;

/**
 * @author tham
 *
 * General exception for our application
 */

public class DropwizardSkolException extends Throwable {
    private int code;

    public DropwizardSkolException(int code) {
        this(code, "Error while processing the request", null);
    }

    public DropwizardSkolException(int code, String message) {
        this(code, message, null);
    }

    public DropwizardSkolException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
