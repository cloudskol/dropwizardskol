package com.cloudskol.dropwizardskol.managed;

import io.dropwizard.lifecycle.Managed;

/**
 * @author tham
 */

public class ElasticClientManager implements Managed {

    public void start() throws Exception {
        System.out.println("Elastic client manager start");
    }

    public void stop() throws Exception {
        System.out.println("Elastic client manager stop");
    }
}
