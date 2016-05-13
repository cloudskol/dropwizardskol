package com.cloudskol.dropwizardskol;

import com.cloudskol.dropwizardskol.core.DropwizardSkolExceptionMapper;
import com.cloudskol.dropwizardskol.health.DropwizardSkolHealth;
import com.cloudskol.dropwizardskol.managed.ElasticClientManager;
import com.cloudskol.dropwizardskol.resource.BookResource;
import com.cloudskol.dropwizardskol.task.RebootElasticTask;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author tham
 *
 * Main entry point for our application
 *
 * Resources, health check and providers will be registered here
 */
public class DropwizardSkolApplication extends Application<DropwizardSkolConfiguration> {
    private static final String value = "Hello %s";

    public static void main(String[] args) throws Exception {
        new DropwizardSkolApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardSkolConfiguration> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new AssetsBundle("/assets", "/dskol", "index.html"));
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
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
        environment.jersey().setUrlPattern("/dskol/api/*");
        BookResource bookResource = new BookResource();
        environment.jersey().register(bookResource);
        environment.jersey().register(new DropwizardSkolExceptionMapper());
    }
}
