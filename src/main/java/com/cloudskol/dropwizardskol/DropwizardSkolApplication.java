package com.cloudskol.dropwizardskol;

import com.cloudskol.dropwizardskol.health.DropwizardSkolHealth;
import com.cloudskol.dropwizardskol.managed.ElasticClientManager;
import com.cloudskol.dropwizardskol.resource.BookResource;
import com.cloudskol.dropwizardskol.task.RebootElasticTask;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by tham on 12-02-2016.
 */
public class DropwizardSkolApplication extends Application<DropwizardSkolConfiguration> {
    private static final String value = "Hello %s";

    public static void main(String[] args) throws Exception {
        new DropwizardSkolApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardSkolConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(DropwizardSkolConfiguration dropwizardSkolConfiguration,
                    Environment environment) throws Exception {

        //Register health check
        final DropwizardSkolHealth dropwizardSkolHealth = new DropwizardSkolHealth(value);
        environment.healthChecks().register("Health", dropwizardSkolHealth);

        //Register tasks
        environment.admin().addTask(new RebootElasticTask("reboot"));

        //Register managed objects
        environment.lifecycle().manage(new ElasticClientManager());

        //Register resource
        BookResource bookResource = new BookResource();
        environment.jersey().register(bookResource);
    }
}
