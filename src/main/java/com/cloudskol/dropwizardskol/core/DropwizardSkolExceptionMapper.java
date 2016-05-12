package com.cloudskol.dropwizardskol.core;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author tham
 *
 * Represents the exception mapper
 */

@Provider
public class DropwizardSkolExceptionMapper implements ExceptionMapper<DropwizardSkolException> {
    public Response toResponse(DropwizardSkolException exception) {
        return Response.status(exception.getCode())
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
