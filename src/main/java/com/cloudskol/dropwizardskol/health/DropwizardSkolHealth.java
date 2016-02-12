package com.cloudskol.dropwizardskol.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author tham
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
            throw new Exception("DropwizardSkol application is NOT healthy");
        }

        return Result.healthy();
    }
}
