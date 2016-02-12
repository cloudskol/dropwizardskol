package com.cloudskol.dropwizardskol;

import com.cloudskol.dropwizardskol.resource.BookResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by tham on 12-02-2016.
 */
public class DropwizardSkolApplication extends Application<DropwizardSkolConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardSkolApplication().run(args);
    }

    @Override
    public void run(DropwizardSkolConfiguration dropwizardSkolConfiguration,
                    Environment environment) throws Exception {
        System.out.println("My Application is started");

        BookResource bookResource = new BookResource();
        environment.jersey().register(bookResource);
    }
}
