package com.cloudskol.dropwizardskol.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author tham
 *
 * Health check for our application
 */

public class DropwizardSkolHealth extends HealthCheck {
    private String value;

    public DropwizardSkolHealth(String value) {
        this.value = value;
    }

    @Override
    protected Result check() throws Exception {
        final String formattedString = String.format(value, "CloudSkol");
        if (!formattedString.contains("CloudSkol")) {
            return Result.unhealthy("DropwizardSkol application is NOT healthy...");
        }

        return Result.healthy("DropwizardSkol application is healthy");
    }
}
