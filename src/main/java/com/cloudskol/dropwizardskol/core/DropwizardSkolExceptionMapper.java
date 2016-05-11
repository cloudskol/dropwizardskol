package com.cloudskol.dropwizardskol.core;

import javax.ws.rs.core.Response;

/**
 * @author tham
 */

public class DropwizardSkolExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<DropwizardSkolException> {
    public Response toResponse(DropwizardSkolException exception) {
        return null;
    }
}
