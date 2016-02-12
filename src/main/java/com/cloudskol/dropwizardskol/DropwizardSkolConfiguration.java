package com.cloudskol.dropwizardskol;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by tham on 12-02-2016.
 */
public class DropwizardSkolConfiguration extends Configuration {
    private String name;

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
}
